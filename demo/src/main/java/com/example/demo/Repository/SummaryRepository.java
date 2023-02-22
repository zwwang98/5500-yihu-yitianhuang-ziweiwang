package com.example.demo.Repository;

import com.example.demo.Model.Summary;
import org.springframework.data.repository.CrudRepository;

public interface SummaryRepository extends CrudRepository<Summary, Integer> {
Summary findByRecordId(Integer recordId);
}
