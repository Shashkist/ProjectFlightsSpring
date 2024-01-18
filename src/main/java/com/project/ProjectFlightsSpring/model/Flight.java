package com.project.ProjectFlightsSpring.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate departureTime;

    LocalDate landingTime;

    int remainingTickets;

    String flightNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    private Country originCountry;

    @ManyToOne(cascade = CascadeType.ALL)
    private Country destinationCountry;

    @ManyToOne(cascade = CascadeType.ALL)
    private AirlineCompany airlineCompany;

}
