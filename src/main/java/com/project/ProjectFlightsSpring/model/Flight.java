package com.project.ProjectFlightsSpring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    LocalDate departureTime;

    LocalDate landingTime;

    int remainingTickets;

    @ManyToOne
    private Country originCountry;

    @ManyToOne
    private Country destinationCountry;

    @ManyToOne
    private AirlineCompany airlineCompany;

}
