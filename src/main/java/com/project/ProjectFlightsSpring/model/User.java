package com.project.ProjectFlightsSpring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection  = "app_user")
public class User {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String userName;
    private String password;
    private String email;
}
