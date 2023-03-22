package com.cs5500.fitness.controller;

import com.cs5500.fitness.model.Place;
import com.cs5500.fitness.model.Segment;
import com.cs5500.fitness.model.Summary;
import com.cs5500.fitness.repository.PlaceRepository;
import com.cs5500.fitness.repository.SegmentRepository;
import com.cs5500.fitness.repository.SummaryRepository;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController {

  private final SegmentRepository segmentRepository;
  private final SummaryRepository summaryRepository;
  private final PlaceRepository placeRepository;

  public RankController(SegmentRepository segmentRepository,
      SummaryRepository summaryRepository,
      PlaceRepository placeRepository) {
    this.segmentRepository = segmentRepository;
    this.summaryRepository = summaryRepository;
    this.placeRepository = placeRepository;
  }

  /**
   * @return Activities with most total time, probably only top 5 given limited activities.
   */
  @GetMapping("/rank/activity")
  List<Map.Entry<String, Double>> topActivities() {
    /*
     * 1. Read all items from the table "summary"
     * 2. Calculate total time for each activity
     * 3. Rank it
     * */

    List<Summary> allSummaryItem = summaryRepository.findAll();

    Map<String, Double> activityToTotalTime = new HashMap<>();

    for (Summary item : allSummaryItem) {
      String activity = item.getActivity();
      Double duration = item.getDuration();
      activityToTotalTime.putIfAbsent(activity, 0.0);
      activityToTotalTime.put(
          activity,
          activityToTotalTime.get(activity) + duration
      );
    }

    List<Map.Entry<String, Double>> sortedEntryList = new ArrayList<>(activityToTotalTime.entrySet());

    // sort ascending by value in key-value pair and reverse the order
    sortedEntryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

    return sortedEntryList;
  }

  @GetMapping("/rank/location")
  List<String> topLocations() {
    /*
     * 1. Read all items from the table "segment"
     * 2. Calculate total time for each activity
     * 3. Rank it
     * */

    List<Segment> allSegmentItem = segmentRepository.findAll();
    List<Place> allPlaceItem = placeRepository.findAll();

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
      if (placeRepository.findById(Item.getKey()).isPresent() && sortedPlaceNameList.size() < 10) {
        Place curPlace = placeRepository.findById(Item.getKey()).get();
        if (Objects.equals(curPlace.getName(), "") || Objects.equals(curPlace.getName(), "Home")) {
          continue;
        }
        sortedPlaceNameList.add(curPlace.getName());
      }

    }

    return sortedPlaceNameList;
  }
}
