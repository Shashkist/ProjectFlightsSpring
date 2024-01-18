package com.project.ProjectFlightsSpring.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Document
public class Flight {

    @Id
    private String id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate departureTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate landingTime;

    int remainingTickets;

    String flightNumber;

    private Country originCountry;


    private Country destinationCountry;


    private AirlineCompany airlineCompany;

}
