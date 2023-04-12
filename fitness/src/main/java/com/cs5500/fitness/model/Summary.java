package com.cs5500.fitness.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "summary")
public class Summary {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "summary_id")
  private Integer id;

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

  public Integer getId() {
    return id;
  }

  public String getActivity() {
    return activity;
  }

  public String getCategory() {
    return category;
  }

  public Double getDuration() {
    return duration;
  }

  public Double getDistance() {
    return distance;
  }

  public Double getSteps() {
    return steps;
  }

  public Double getCalories() {
    return calories;
  }

  public Integer getRecordId() {
    return recordId;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setDuration(Double duration) {
    this.duration = duration;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

  public void setSteps(Double steps) {
    this.steps = steps;
  }

  public void setCalories(Double calories) {
    this.calories = calories;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }

  @Override
  public String toString() {
    return "Summary{" +
        "id=" + id +
        ", activity='" + activity + '\'' +
        ", category='" + category + '\'' +
        ", duration=" + duration +
        ", distance=" + distance +
        ", steps=" + steps +
        ", calories=" + calories +
        ", recordId=" + recordId +
        '}';
  }
}
