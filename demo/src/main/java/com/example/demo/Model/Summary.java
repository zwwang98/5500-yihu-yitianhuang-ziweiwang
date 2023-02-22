package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "summary")
public class Summary {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "activity", nullable = false)
  private String activity;

  @Column(name = "category")
  private String category;

  @Column(name = "duration", nullable = false)
  private Double duration;

  @Column(name = "distance", nullable = false)
  private Double distance;

  @Column(name = "steps")
  private Double steps;

  @Column(name = "calories")
  private Double calories;

  @Column(name = "record_id", nullable = false)
  private Integer recordId;

  // getters and setters

  public String getActivity() {
    return activity;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  public String getcategory() {
    return category;
  }

  public void setcategory(String category) {
    this.category = category;
  }

  public Double getDuration() {
    return duration;
  }

  public void setDuration(Double duration) {
    this.duration = duration;
  }

  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

  public Double getSteps() {
    return steps;
  }

  public void setSteps(Double steps) {
    this.steps = steps;
  }

  public Double getCalories() {
    return calories;
  }

  public void setCalories(Double calories) {
    this.calories = calories;
  }

  public Integer getRecordId() {
    return recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }
}