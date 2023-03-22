package com.cs5500.fitness.controller;

import com.cs5500.fitness.model.Summary;
import com.cs5500.fitness.repository.SegmentRepository;
import com.cs5500.fitness.repository.SummaryRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController {

  private final SegmentRepository segmentRepository;
  private final SummaryRepository summaryRepository;

  public RankController(SegmentRepository segmentRepository,
      SummaryRepository summaryRepository) {
    this.segmentRepository = segmentRepository;
    this.summaryRepository = summaryRepository;
  }

  /**
   * @return Activities with most total time, probably only top 5 given limited activities.
   */
  @GetMapping("/rank/activity")
  List<Map.Entry<String, Double>> topActivities() {
    /*
    * 1. Read all items from the table "summary"
    * 2. Calculate total time for each activity
    * 3. Rank
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

    List<Map.Entry<String, Double>> entryList = new ArrayList<>(activityToTotalTime.entrySet());

    // sort ascending by value in key-value pair and reverse the order
    entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

    return entryList;
  }
}
