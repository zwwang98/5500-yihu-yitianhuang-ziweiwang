package com.cs5500.fitness.repository;

import com.cs5500.fitness.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

}
