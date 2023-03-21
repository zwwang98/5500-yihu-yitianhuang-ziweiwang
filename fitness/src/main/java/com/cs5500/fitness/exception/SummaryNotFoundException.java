package com.cs5500.fitness.exception;

public class SummaryNotFoundException extends RuntimeException {
  public SummaryNotFoundException(Integer id) {
    super("Could not find employee " + id);
  }
}
