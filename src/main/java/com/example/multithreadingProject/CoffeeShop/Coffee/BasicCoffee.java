package com.example.multithreadingProject.CoffeeShop.Coffee;

public class BasicCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Basic coffee";
    }

    @Override
    public Double getCost() {
        return 10.00;
    }
}
