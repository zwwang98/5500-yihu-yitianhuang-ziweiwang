package com.cs5500.fitness.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Pattern;

@RestController
public class RecommendationController {

  @GetMapping("/recommendation/activity/height/{height}/weight/{weight}/gender/{gender}/age/{age}")
  public Map<String, Integer> recommendActivity(
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
}
