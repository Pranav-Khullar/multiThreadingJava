package com.example.multithreadingProject.NullObject;

public class NullVehicle implements Vehicle{
    @Override
    public Integer getSeatingCapacity() {
        return 0;
    }

    @Override
    public Integer getTankCapacity() {
        return 0;
    }
}
