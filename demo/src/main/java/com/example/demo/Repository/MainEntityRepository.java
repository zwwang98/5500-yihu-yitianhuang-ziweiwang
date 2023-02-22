package com.example.demo.Repository;

import com.example.demo.Model.MainEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainEntityRepository extends CrudRepository<MainEntity, Integer> {

  MainEntity findByRecordId(Integer id);

}