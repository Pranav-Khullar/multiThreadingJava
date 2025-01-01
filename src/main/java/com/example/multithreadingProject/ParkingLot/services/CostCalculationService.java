package com.example.multithreadingProject.ParkingLot.services;

import java.time.LocalDateTime;

public interface CostCalculationService {
    Double calculateCost(Long duration);
}
