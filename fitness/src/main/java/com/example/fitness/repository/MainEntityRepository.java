package com.example.fitness.repository;

import com.example.fitness.model.MainEntity;
import org.springframework.data.repository.CrudRepository;

public interface MainEntityRepository extends CrudRepository<MainEntity, Integer> {

  MainEntity findByRecordId(Integer id);
}
