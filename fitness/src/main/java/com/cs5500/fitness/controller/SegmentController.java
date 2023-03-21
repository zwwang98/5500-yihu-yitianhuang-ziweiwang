package com.cs5500.fitness.controller;

import com.cs5500.fitness.model.Segment;
import com.cs5500.fitness.repository.SegmentRepository;
import java.util.Optional;
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
  Optional<Segment> one(@PathVariable Integer id) {
    return repository.findById(id);
  }
}
