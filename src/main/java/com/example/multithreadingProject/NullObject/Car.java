package com.example.multithreadingProject.NullObject;

public class Car implements Vehicle{
    @Override
    public Integer getSeatingCapacity() {
        return 5;
    }

    @Override
    public Integer getTankCapacity() {
        return 30;
    }
}
