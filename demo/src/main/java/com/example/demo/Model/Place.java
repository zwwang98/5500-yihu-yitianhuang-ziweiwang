package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "place")
public class Place {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "foursquareId")
  private String foursquareId;

  @Column(name = "lat", nullable = false)
  private String lat;

  @Column(name = "lon", nullable = false)
  private String lon;

  // getters and setters

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getFoursquareId() {
    return foursquareId;
  }

  public void setFoursquareId(String foursquareId) {
    this.foursquareId = foursquareId;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLon() {
    return lon;
  }

  public void setLon(String lon) {
    this.lon = lon;
  }
}