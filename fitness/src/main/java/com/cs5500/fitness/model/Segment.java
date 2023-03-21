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

  @Column(name = "place")
  private Integer place;

  @Column(name = "lastUpdate", nullable = false)
  private String lastUpdate;

  @Column(name = "record_id", nullable = false)
  private Integer recordId;

  @Column(name = "segment_id", nullable = false)
  private Integer segmentId;


}
