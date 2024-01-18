package com.project.ProjectFlightsSpring.data;

import com.project.ProjectFlightsSpring.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("select c from Country c where LOWER(c.name) =  LOWER(:name)")
    Country findByNameIgnoreCase(String name);
}
