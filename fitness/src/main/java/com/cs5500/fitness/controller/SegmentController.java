package com.cs5500.fitness.controller;

import com.cs5500.fitness.exception.SegmentNotFoundException;
import com.cs5500.fitness.model.Segment;
import com.cs5500.fitness.repository.SegmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SegmentController {

  private final SegmentRepository repository;

  SegmentController(SegmentRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/segment/{id}")
  Segment one(@PathVariable Integer id) {
    return repository.findById(id)
        .orElseThrow(() -> new SegmentNotFoundException(id));
  }
}
