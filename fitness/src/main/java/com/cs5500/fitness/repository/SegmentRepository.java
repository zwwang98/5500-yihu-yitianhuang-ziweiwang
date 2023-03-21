package com.cs5500.fitness.repository;

import com.cs5500.fitness.model.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, Integer> {

}
