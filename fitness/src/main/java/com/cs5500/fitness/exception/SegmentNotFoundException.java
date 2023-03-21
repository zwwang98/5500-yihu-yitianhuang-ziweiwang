package com.cs5500.fitness.exception;

public class SegmentNotFoundException extends RuntimeException {
  public SegmentNotFoundException(Integer id) {
    super("Could not find segment " + id);
  }
}
