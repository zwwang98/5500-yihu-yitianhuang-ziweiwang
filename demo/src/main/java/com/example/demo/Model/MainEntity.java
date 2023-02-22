package com.example.demo.Model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "main")
public class MainEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "record_id")
  private Integer recordId;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "caloriesidle", nullable = false)
  private Integer caloriesidle;

  @Column(name = "lastupdate", nullable = false)
  private String lastupdate;

  // constructors, getters, and setters

  public MainEntity(Integer recordId, LocalDate date, Integer caloriesIdle,
      String lastUpdate) {
    this.recordId = recordId;
    this.date = date;
    this.caloriesidle = caloriesIdle;
    this.lastupdate = lastUpdate;
  }

  public MainEntity() {
  }

  public Integer getRecordId() {
    return recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Integer getCaloriesIdle() {
    return caloriesidle;
  }

  public void setCaloriesIdle(Integer caloriesIdle) {
    this.caloriesidle = caloriesIdle;
  }

  public String getLastUpdate() {
    return lastupdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastupdate = lastUpdate;
  }
}
