package com.example.multithreadingProject.ParkingLot.models;

public class TwoWheelerVehicle extends Vehicle{

    public TwoWheelerVehicle(String number) {
        super(number);
    }

    @Override
    public String getType() {
        return "two-wheeler";
    }
}
