package com.example.multithreadingProject.ParkingLot.services;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service("two-wheeler")
public class TwoWheelerCostCalculator implements CostCalculationService{

    Double costPerHour = 20.00;

    @Override
    public Double calculateCost(Long duration) {
        return duration * costPerHour;
    }
}
