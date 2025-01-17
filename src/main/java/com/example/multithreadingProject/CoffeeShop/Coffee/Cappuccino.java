package com.example.multithreadingProject.CoffeeShop.Coffee;

public class Cappuccino implements Coffee{
    @Override
    public String getDescription() {
        return "Cappuccino";
    }

    @Override
    public Double getCost() {
        return 15.00;
    }
}
