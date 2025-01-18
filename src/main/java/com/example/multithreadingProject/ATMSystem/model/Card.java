package com.example.multithreadingProject.ATMSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    private String id;
    private User user;
    private String number;
    private int pin;
}
