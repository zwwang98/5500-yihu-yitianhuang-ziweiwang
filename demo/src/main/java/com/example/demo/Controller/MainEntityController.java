package com.example.demo.Controller;

import com.example.demo.Repository.MainEntityRepository;
import com.example.demo.Model.MainEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainEntityController {

  @Autowired
  private MainEntityRepository mainEntityRepository;

  @GetMapping("/findbyid/{id}")
  public MainEntity get(@PathVariable String id) {
    return mainEntityRepository.findByRecordId(Integer.parseInt(id));
  }
}
