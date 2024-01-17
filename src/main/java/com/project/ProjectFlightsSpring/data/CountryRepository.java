package com.project.ProjectFlightsSpring.data;

import com.project.ProjectFlightsSpring.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
