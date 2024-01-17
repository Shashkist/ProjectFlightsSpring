package com.project.ProjectFlightsSpring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AirlineCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Country country;


}
