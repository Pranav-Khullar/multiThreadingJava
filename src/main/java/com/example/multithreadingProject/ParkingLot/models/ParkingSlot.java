package com.example.multithreadingProject.ParkingLot.models;

public class ParkingSlot {
    private Boolean occupied;
    private Vehicle vehicle;

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
