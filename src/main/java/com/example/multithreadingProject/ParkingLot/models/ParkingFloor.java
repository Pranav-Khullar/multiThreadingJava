package com.example.multithreadingProject.ParkingLot.models;

import java.util.*;

public class ParkingFloor {
    Queue<Integer> availableSlots = new LinkedList<>();
    Map<Integer, ParkingSlot> parkingSlotMap = new HashMap<>();

    public ParkingFloor(Integer slots) {
        for(int i=1; i<= slots; ++i) {
            parkingSlotMap.put(i, new ParkingSlot());
            availableSlots.add(i);
        }
    }

    public Boolean isSlotAvailable() {
        return !availableSlots.isEmpty();
    }

    public Integer parkVehicle(Vehicle vehicle) {
        if (availableSlots.isEmpty()) {
            throw new RuntimeException();
        }

        Integer slotNumber = availableSlots.poll();
        ParkingSlot slot = parkingSlotMap.get(slotNumber);
        slot.setOccupied(true);
        slot.setVehicle(vehicle);

        return slotNumber;
    }

    public Vehicle unparkVehicle(Integer slotNumber) {
        if (!parkingSlotMap.containsKey(slotNumber)) {
            throw new RuntimeException();
        }
        ParkingSlot slot = parkingSlotMap.get(slotNumber);
        if (!slot.getOccupied()) {
            throw new RuntimeException();
        }
        Vehicle vehicle = slot.getVehicle();
        slot.setVehicle(null);
        slot.setOccupied(false);
        availableSlots.add(slotNumber);

        return vehicle;
    }
}
