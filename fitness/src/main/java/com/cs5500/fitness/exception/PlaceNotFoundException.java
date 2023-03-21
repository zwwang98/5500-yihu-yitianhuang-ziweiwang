package com.cs5500.fitness.exception;

public class PlaceNotFoundException extends RuntimeException {
  public PlaceNotFoundException(Integer id) {
    super("Could not find place " + id);
  }
}

