package com.example.multithreadingProject.ParkingLot.services;

public class EightWheelerCostCalculator implements CostCalculationService{

    private Double costPerHour = 80.00;

    @Override
    public Double calculateCost(Long duration) {
        return duration * costPerHour;
    }
}
