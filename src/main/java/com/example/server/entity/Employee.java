package com.example.server.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {

    private String documentId;
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private String description;


    public void add(Employee employee) {
    }
}
