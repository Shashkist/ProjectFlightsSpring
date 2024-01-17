package com.project.ProjectFlightsSpring.data;

import com.project.ProjectFlightsSpring.model.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightsRepository extends CrudRepository<Flight, Long> {
}
