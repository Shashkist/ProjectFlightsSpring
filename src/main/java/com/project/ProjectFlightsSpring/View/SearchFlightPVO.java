package com.project.ProjectFlightsSpring.View;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class SearchFlightPVO {

    String from;
    String to;
    LocalTime departureTime;
    LocalTime landingTime;
    Integer numberOfTickets;

}
