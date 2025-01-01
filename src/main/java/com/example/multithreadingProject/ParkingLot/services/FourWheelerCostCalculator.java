package com.example.multithreadingProject.ParkingLot.services;

import java.time.Duration;
import java.time.LocalDateTime;

public class FourWheelerCostCalculator implements CostCalculationService{

    Double costPerHour = 40.00;

    @Override
    public Double calculateCost(Long duration) {
        return duration * costPerHour;
    }
}
