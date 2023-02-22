package com.example.fitness.controller;

import com.example.fitness.model.MainEntity;
import com.example.fitness.repository.MainEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  private MainEntityRepository mainEntityRepository;

  @GetMapping("/test/find-main-entity-by-id/{id}")
  public MainEntity test(@PathVariable String id) {
    return mainEntityRepository.findByRecordId(Integer.parseInt(id));
  }

}
