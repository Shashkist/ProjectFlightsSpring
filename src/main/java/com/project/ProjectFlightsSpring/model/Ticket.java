package com.project.ProjectFlightsSpring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Ticket {
    @Id
    private String id;




    private Flight flight;



    private Customer customer;




}
