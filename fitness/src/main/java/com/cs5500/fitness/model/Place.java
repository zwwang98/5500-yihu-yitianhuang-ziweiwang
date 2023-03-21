package com.cs5500.fitness.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "place")
public class Place {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Column(name = "foursquareid")
  private String foursquareId;

  @Column(name = "lat")
  private String lat;

  @Column(name = "lon")
  private String lon;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getFoursquareId() {
    return foursquareId;
  }

  public String getLat() {
    return lat;
  }

  public String getLon() {
    return lon;
  }

  @Override
  public String toString() {
    return "Place{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", type='" + type + '\'' +
        ", foursquareId='" + foursquareId + '\'' +
        ", lat='" + lat + '\'' +
        ", lon='" + lon + '\'' +
        '}';
  }
}
