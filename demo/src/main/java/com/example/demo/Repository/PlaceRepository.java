package com.example.demo.Repository;

import com.example.demo.Model.Place;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Integer> {

  Optional<Place> findById(Integer id);
}
