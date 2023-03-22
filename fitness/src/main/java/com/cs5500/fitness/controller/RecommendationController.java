package com.cs5500.fitness.controller;

import com.cs5500.fitness.model.Place;
import com.cs5500.fitness.model.Segment;
import com.cs5500.fitness.repository.PlaceRepository;
import com.cs5500.fitness.repository.SegmentRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Pattern;

@RestController
public class RecommendationController {

  private final PlaceRepository placeRepository;
  private final SegmentRepository segmentRepository;

  public RecommendationController(PlaceRepository placeRepository,
      SegmentRepository segmentRepository) {
    this.placeRepository = placeRepository;
    this.segmentRepository = segmentRepository;
  }

  @GetMapping("/recommendation/activity/height/{height}/weight/{weight}/gender/{gender}/age/{age}")
  public Map<String, Integer> recommendActivityForCalories(
      @PathVariable("height") @Pattern(regexp = "^([1-7](\\.\\d)?|8(\\.0)?)$") Double height,
      @PathVariable("weight") @Pattern(regexp = "^([0-9]?[0-9]{0,2}(?:,[0-9]{3})*|[0-1][0-9]{3}(?:,[0-9]{3})*|2000)(?:\\.\\d{1,2})?$") Integer weight,
      @PathVariable("gender") @Pattern(regexp = "^(male|female)$") String gender,
      @PathVariable("age") @Pattern(regexp = "^([1-9]?\\d|1\\d{2}|200)$") Integer age
  ) {
    double calories = 0.0;

    // Reference: Medical News Today
    if (Objects.equals(gender, "male")) {
      calories = 66 + (6.2 * weight) + (12.7 * height) - (6.76 * age);
    } else if (Objects.equals(gender, "female")) {
      calories = 655.1 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
    }

    System.out.format("Calories: %f\n", calories);

    Map<String, Double> MET = new HashMap<>();
    MET.put("Jogging", 7.0);
    MET.put("Running", 11.0);
    MET.put("Swimming", 8.0);
    MET.put("Jumping rope", 11.0);
    MET.put("Cycling", 9.0);
    MET.put("Yoga", 3.5);
    MET.put("Tennis", 7.0);

    Map<String, Integer> sportTime = new HashMap<>();
    for (String sport : MET.keySet()) {
      double time = calories / (MET.get(sport) * weight);
      sportTime.put(sport, (int) Math.round(time * 60));
    }

    return sportTime;
  }

  @GetMapping("/recommendation/activity/location/{latitude}/{longtitude}")
  public Map<String, Integer> recommendActivityOnLocation(
      @PathVariable Double latitude,
      @PathVariable Double longtitude
  ) {

    /*
     * 1. In table "place", find the closest k places from place [latitude, longtitude]
     * 2. In table "segment", Find activities happened at those places
     * 3. Rank activities above by freq
     * */

    int k = 10000000;

    Place source = new Place();
    source.setLat(latitude.toString());
    source.setLon(longtitude.toString());

    // Max-Heap
    PriorityQueue<Place> kClosestPlaces = new PriorityQueue<>(
        (a, b) -> Double.compare(calcDistance(source, b), calcDistance(source, a))
    );

    Set<Integer> kClosestPlaceIds = new HashSet<>();

    // find k-closest places by maintaining a size-k max-heap
    List<Place> allPlaceItems = placeRepository.findAll();
    for (Place place : allPlaceItems) {
      kClosestPlaces.add(place);
      kClosestPlaceIds.add(place.getId());
      if (kClosestPlaces.size() > k) {
        kClosestPlaceIds.remove(kClosestPlaces.poll().getId());
      }
    }

    Map<String, Integer> activityToFreq = new HashMap<>();
    List<Segment> allSegmentItems = segmentRepository.findAll();
    for (Segment segment : allSegmentItems) {
      Integer placeId = segment.getPlace();
      String activity = segment.getActivity();

      if (!kClosestPlaceIds.contains(placeId)) {
        continue;
      }

      activityToFreq.putIfAbsent(activity, 0);
      activityToFreq.put(
          activity,
          activityToFreq.get(activity) + 1
      );
    }

    return activityToFreq;
  }

  private Double calcDistance(Place source, Place destination) {
    Double sLat = Double.parseDouble(source.getLat());
    Double sLon = Double.parseDouble(source.getLon());
    Double dLat = Double.parseDouble(destination.getLat());
    Double dLon = Double.parseDouble(destination.getLon());

    return Math.sqrt(
        Math.pow(dLat - sLat, 2) + Math.pow(dLon - sLon, 2)
    );
  }
}
