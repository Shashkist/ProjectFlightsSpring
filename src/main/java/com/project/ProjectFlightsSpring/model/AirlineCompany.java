package com.project.ProjectFlightsSpring.model;

import lombok.Data;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "airlineCompanies")
public class AirlineCompany {

    @Id
    private String id;

    private String name;


    private Country country;


}
