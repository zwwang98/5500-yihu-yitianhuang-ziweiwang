package com.cs5500.fitness.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class ActivityRecord {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name = "record_id")
  private Integer id;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "caloriesidle", nullable = false)
  private Integer caloriesIdle;

  @Column(name = "lastupdate", nullable = false)
  private String lastUpdate;

  public Integer getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }

  public Integer getCaloriesIdle() {
    return caloriesIdle;
  }

  public String getLastUpdate() {
    return lastUpdate;
  }

  @Override
  public String toString() {
    return "ActivityRecord{" +
        "id=" + id +
        ", date=" + date +
        ", caloriesIdle=" + caloriesIdle +
        ", lastUpdate='" + lastUpdate + '\'' +
        '}';
  }
}
