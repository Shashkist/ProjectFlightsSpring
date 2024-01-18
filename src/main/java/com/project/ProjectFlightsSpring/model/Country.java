package com.project.ProjectFlightsSpring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
public class Country {

    public Country() {

    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    private String name;


    public Country(String name) {
        this.name = name;
    }
}
