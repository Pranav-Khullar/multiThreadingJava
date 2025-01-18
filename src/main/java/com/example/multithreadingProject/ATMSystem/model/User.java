package com.example.multithreadingProject.ATMSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Double balance;
}
