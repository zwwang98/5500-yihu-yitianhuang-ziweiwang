package com.cs5500.fitness.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "segment")
public class Segment {
  @Column(name = "activity", nullable = false)
  private String activity;

  @Column(name = "category")
  private String category;

  @Column(name = "manual", nullable = false)
  private String manual;

  @Column(name = "starttime_x")
  private String startTimeX;

  @Column(name = "endtime_x")
  private String endTimeX;

  @Column(name = "duration", nullable = false)
  private Double duration;

  @Column(name = "distance", nullable = false)
  private Double distance;

  @Column(name = "steps")
  private Double steps;

  @Column(name = "calories")
  private Double calories;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "activity_id")
  private Integer activityId;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "starttime_y", nullable = false)
  private String startTimeY;

  @Column(name = "endtime_y", nullable = false)
  private String endTimeY;

  @Column(name = "place")
  private Integer place;

  @Column(name = "lastupdate", nullable = false)
  private String lastUpdate;

  @Column(name = "record_id", nullable = false)
  private Integer recordId;

  @Column(name = "segment_id", nullable = false)
  private Integer segmentId;

  public String getActivity() {
    return activity;
  }

  public String getCategory() {
    return category;
  }

  public String getManual() {
    return manual;
  }

  public String getStartTimeX() {
    return startTimeX;
  }

  public String getEndTimeX() {
    return endTimeX;
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

  public Integer getActivityId() {
    return activityId;
  }

  public String getType() {
    return type;
  }

  public String getStartTimeY() {
    return startTimeY;
  }

  public String getEndTimeY() {
    return endTimeY;
  }

  public Integer getPlace() {
    return place;
  }

  public String getLastUpdate() {
    return lastUpdate;
  }

  public Integer getRecordId() {
    return recordId;
  }

  public Integer getSegmentId() {
    return segmentId;
  }

  @Override
  public String toString() {
    return "Segment{" +
        "activityId=" + activityId +
        ", activity='" + activity + '\'' +
        ", category='" + category + '\'' +
        ", manual='" + manual + '\'' +
        ", startTimeX='" + startTimeX + '\'' +
        ", endTimeX='" + endTimeX + '\'' +
        ", duration=" + duration +
        ", distance=" + distance +
        ", steps=" + steps +
        ", calories=" + calories +
        ", type='" + type + '\'' +
        ", startTimeY='" + startTimeY + '\'' +
        ", endTimeY='" + endTimeY + '\'' +
        ", place=" + place +
        ", lastUpdate='" + lastUpdate + '\'' +
        ", recordId=" + recordId +
        ", segmentId=" + segmentId +
        '}';
  }
}
