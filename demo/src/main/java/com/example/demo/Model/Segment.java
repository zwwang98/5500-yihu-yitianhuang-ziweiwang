package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "segment")
public class Segment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "activity_id")
  private Integer activityId;

  @Column(name = "activity", nullable = false)
  private String activity;

  @Column(name = "category")
  private String category;

  @Column(name = "manual", nullable = false)
  private String manual;

  @Column(name = "startTime_x")
  private String startTimeX;

  @Column(name = "endTime_x")
  private String endTimeX;

  @Column(name = "duration", nullable = false)
  private Double duration;

  @Column(name = "distance", nullable = false)
  private Double distance;

  @Column(name = "steps")
  private Double steps;

  @Column(name = "calories")
  private Double calories;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "startTime_y", nullable = false)
  private String startTimeY;

  @Column(name = "endTime_y", nullable = false)
  private String endTimeY;

  @ManyToOne
  @JoinColumn(name = "place")
  private Place place;

  @Column(name = "lastUpdate", nullable = false)
  private String lastUpdate;

  @Column(name = "record_id", nullable = false)
  private Integer recordId;

  @Column(name = "segment_id", nullable = false)
  private Integer segmentId;

  // getters and setters

  public Integer getActivityId() {
    return activityId;
  }

  public void setActivityId(Integer activityId) {
    this.activityId = activityId;
  }

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

  public String getManual() {
    return manual;
  }

  public void setManual(String manual) {
    this.manual = manual;
  }

  public String getStartTimeX() {
    return startTimeX;
  }

  public void setStartTimeX(String startTimeX) {
    this.startTimeX = startTimeX;
  }

  public String getEndTimeX() {
    return endTimeX;
  }

  public void setEndTimeX(String endTimeX) {
    this.endTimeX = endTimeX;
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStartTimeY() {
    return startTimeY;
  }

  public void setStartTimeY(String startTimeY) {
    this.startTimeY = startTimeY;
  }

  public String getEndTimeY() {
    return endTimeY;
  }

  public void setEndTimeY(String endTimeY) {
    this.endTimeY = endTimeY;
  }

  public Place getPlace() {
    return place;
  }

  public void setPlace(Place place) {
    this.place = place;
  }

  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public Integer getRecordId() {
    return recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }

  public Integer getSegmentId() {
    return segmentId;
  }

  public void setSegmentId(Integer segmentId) {
    this.segmentId = segmentId;
  }
}