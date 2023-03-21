package com.cs5500.fitness.repository;

import com.cs5500.fitness.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {


}
