package com.cs5500.fitness.controller;

import com.cs5500.fitness.exception.RecordNotFoundException;
import com.cs5500.fitness.model.ActivityRecord;
import com.cs5500.fitness.repository.RecordRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityRecordController {

  private final RecordRepository repository;

  ActivityRecordController(RecordRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/record/{id}")
  ActivityRecord one(@PathVariable Integer id) {
    return repository.findById(id)
        .orElseThrow(() -> new RecordNotFoundException(id));
  }
}
