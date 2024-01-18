package com.project.ProjectFlightsSpring.data;

import com.project.ProjectFlightsSpring.model.AirlineCompany;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirlineCompanyRepository extends MongoRepository<AirlineCompany, String > {
}
