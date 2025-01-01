package com.example.multithreadingProject.ParkingLot.models;

import com.example.multithreadingProject.ParkingLot.services.CostCalculationService;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

@Component
public class ParkingLot {

    private Map<Integer, ParkingFloor> floorMap;
    private final Map<String, CostCalculationService> costCalculationServiceMap;

    public ParkingLot(Map<String, CostCalculationService> costCalculationServiceMap) {
        this.costCalculationServiceMap = costCalculationServiceMap;
    }

    public Map<Integer, ParkingFloor> getFloorMap() {
        return floorMap;
    }

    public void setFloorMap(Map<Integer, ParkingFloor> floorMap) {
        this.floorMap = floorMap;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for(Map.Entry<Integer, ParkingFloor> entry: floorMap.entrySet()) {
            if (entry.getValue().isSlotAvailable()) {
                Integer slotNumber = entry.getValue().parkVehicle(vehicle);
                Ticket ticket = new Ticket(entry.getKey(), slotNumber, LocalDateTime.now());
                return ticket;
            }
        }

        // no available slot
        throw new RuntimeException();
    }

    public Double unparkVehicleAndGetCost(Ticket ticket) {
        Vehicle vehicle = floorMap.get(ticket.getFloorNumber()).unparkVehicle(ticket.getSlotNumber());

        Duration duration = Duration.between(LocalDateTime.now(), ticket.getParkingTime());
        Double cost = costCalculationServiceMap.get(vehicle.getType()).calculateCost(duration.getSeconds());
        return cost;
    }

}
