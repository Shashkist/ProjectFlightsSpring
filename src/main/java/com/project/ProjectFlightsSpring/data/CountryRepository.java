package com.project.ProjectFlightsSpring.data;

import com.project.ProjectFlightsSpring.model.Country;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CountryRepository extends MongoRepository<Country, String> {

    @Query("{'name': {$regex : ?0, $options: 'i'}}")
    Country findByNameIgnoreCase(String name);
}
