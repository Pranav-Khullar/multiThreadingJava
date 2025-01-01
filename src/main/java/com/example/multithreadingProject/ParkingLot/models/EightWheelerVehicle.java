package com.example.multithreadingProject.ParkingLot.models;

public class EightWheelerVehicle extends Vehicle{

    public EightWheelerVehicle(String number) {
        super(number);
    }

    @Override
    public String getType() {
        return "eight-wheeler";
    }
}
