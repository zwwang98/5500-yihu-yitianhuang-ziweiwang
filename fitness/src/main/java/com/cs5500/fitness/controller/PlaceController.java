package com.cs5500.fitness.controller;

import com.cs5500.fitness.exception.PlaceNotFoundException;
import com.cs5500.fitness.model.Place;
import com.cs5500.fitness.repository.PlaceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {

  private final PlaceRepository repository;

  PlaceController(PlaceRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/place/{id}")
  Place one(@PathVariable Integer id) {
    return repository.findById(id)
        .orElseThrow(() -> new PlaceNotFoundException(id));
  }
}
