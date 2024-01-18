package com.project.ProjectFlightsSpring.data;

import com.project.ProjectFlightsSpring.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface FlightsRepository extends MongoRepository<Flight, String> {
}
