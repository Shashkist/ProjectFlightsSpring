package com.project.ProjectFlightsSpring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    private Flight flight;


    @ManyToOne
    private Customer customer;




}
