package com.example.multithreadingProject.ParkingLot.models;

public class FourWheelerVehicle extends Vehicle {

    public FourWheelerVehicle(String number) {
        super(number);
    }

    @Override
    public String getType() {
        return "four-wheeler";
    }
}
