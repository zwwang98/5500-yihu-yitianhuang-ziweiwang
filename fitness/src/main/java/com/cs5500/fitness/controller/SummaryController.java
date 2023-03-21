package com.cs5500.fitness.controller;

import com.cs5500.fitness.exception.SummaryNotFoundException;
import com.cs5500.fitness.model.Summary;
import com.cs5500.fitness.repository.SummaryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummaryController {

  private final SummaryRepository repository;

  SummaryController(SummaryRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/summary/{id}")
  Summary one(@PathVariable Integer id) {
    return repository.findById(id)
        .orElseThrow(() -> new SummaryNotFoundException(id));
  }
}
