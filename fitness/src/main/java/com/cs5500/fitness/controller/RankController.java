package com.cs5500.fitness.controller;

import com.cs5500.fitness.model.Place;
import com.cs5500.fitness.model.Segment;
import com.cs5500.fitness.model.Summary;
import com.cs5500.fitness.repository.PlaceRepository;
import com.cs5500.fitness.repository.SegmentRepository;
import com.cs5500.fitness.repository.SummaryRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController {

  private final SegmentRepository segmentRepository;
  private final PlaceRepository placeRepository;

  public RankController(SegmentRepository segmentRepository,
      PlaceRepository placeRepository) {
    this.segmentRepository = segmentRepository;
    this.placeRepository = placeRepository;
  }

  /**
   * @return Activities with most total time.
   */
  @CrossOrigin(origins = "*")
  @GetMapping("/rank/activity/freq")
  List<Map.Entry<String, Double>> topFreqActivities() {
    /*
     * 1. Read all items from the table "segment"
     * 2. Calculate total count for each activity
     * 3. Rank it
     * */

    List<Segment> allSegmentItem = segmentRepository.findAll();

    Map<String, Double> activityToFreq = new HashMap<>();

    for (Segment item : allSegmentItem) {
      String activity = item.getActivity();
      activityToFreq.putIfAbsent(activity, 0.0);
      activityToFreq.put(
          activity,
          activityToFreq.get(activity) + 1
      );
    }

    List<Map.Entry<String, Double>> sortedEntryList = new ArrayList<>(
        activityToFreq.entrySet());

    // sort ascending by value in key-value pair and reverse the order
    sortedEntryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

    return sortedEntryList;
  }

  /**
   * @return Activities with most total calories.
   */
  @CrossOrigin(origins = "*")
  @GetMapping("/rank/activity/calories")
  List<Map.Entry<String, Double>> topCaloriesActivities() {
    /*
     * 1. Read all items from the table "segment"
     * 2. Calculate average calories for each activity
     * 3. Rank it
     * */

    List<Segment> allSegmentItem = segmentRepository.findAll();

    Map<String, Double> activityToTotalCalories = new HashMap<>();
    Map<String, Integer> activityToCnt = new HashMap<>();

    for (Segment item : allSegmentItem) {
      String activity = item.getActivity();
      Double calories = item.getCalories();

      activityToCnt.putIfAbsent(activity, 0);
      activityToCnt.put(
          activity,
          activityToCnt.get(activity) + 1
      );

      activityToTotalCalories.putIfAbsent(activity, 0.0);
      activityToTotalCalories.put(
          activity,
          activityToTotalCalories.get(activity) + (calories == null ? 0.0 : calories)
      );
    }

    Map<String, Double> activityToAvgCalories = new HashMap<>();
    for (String activity : activityToCnt.keySet()) {
      Double totalCalories = activityToTotalCalories.get(activity);
      Integer count = activityToCnt.get(activity);
      Double avgCalories = totalCalories / count;
      activityToAvgCalories.put(activity, avgCalories);
    }

    List<Map.Entry<String, Double>> sortedEntryList = new ArrayList<>(
        activityToAvgCalories.entrySet());

    // sort ascending by value in key-value pair and reverse the order
    sortedEntryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

    return sortedEntryList;
  }

  @CrossOrigin(origins = "*")
  @GetMapping("/rank/location")
  List<String> topLocations() {
    /*
     * 1. Read all items from the table "segment"
     * 2. Calculate total time for each activity
     * 3. Rank it
     * */

    List<Segment> allSegmentItem = segmentRepository.findAll();

    Map<Integer, Integer> placeIdToFreq = new HashMap<>();

    for (Segment item : allSegmentItem) {
      Integer id = item.getPlace();
      placeIdToFreq.putIfAbsent(id, 0);
      placeIdToFreq.put(
          id,
          placeIdToFreq.get(id) + 1
      );
    }

    List<Map.Entry<Integer, Integer>> sortedEntryList = new ArrayList<>(placeIdToFreq.entrySet());

    // sort ascending by value in key-value pair and reverse the order
    sortedEntryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

    // get corresponding place info given place id
    List<String> sortedPlaceNameList = new ArrayList<>();
    for (Map.Entry<Integer, Integer> Item : sortedEntryList) {
      if (Item.getKey() != null &&
          placeRepository.findById(Item.getKey()).isPresent() &&
          sortedPlaceNameList.size() < 10) {
        Place curPlace = placeRepository.findById(Item.getKey()).get();
        System.out.println(curPlace.getName() + " " + Item.getValue());
        if (Objects.equals(curPlace.getName(), "") ||
            Objects.equals(curPlace.getName(), "Home") ||
            Objects.equals(curPlace.getName(), "My Home") ||
            curPlace.getName() == null) {
          continue;
        }
        sortedPlaceNameList.add(curPlace.getName());
      }
    }

    return sortedPlaceNameList;
  }
}