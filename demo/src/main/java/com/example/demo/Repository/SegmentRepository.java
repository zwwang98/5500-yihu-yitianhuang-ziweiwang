package com.example.demo.Repository;

import com.example.demo.Model.Segment;
import org.springframework.data.repository.CrudRepository;

public interface SegmentRepository extends CrudRepository<Segment, Integer> {
  Segment findByRecordId(Integer recordId);
}
