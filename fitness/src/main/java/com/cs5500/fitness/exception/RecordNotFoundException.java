package com.cs5500.fitness.exception;

public class RecordNotFoundException extends RuntimeException {
  public RecordNotFoundException(Integer id) {
    super("Could not find employee " + id);
  }
}
