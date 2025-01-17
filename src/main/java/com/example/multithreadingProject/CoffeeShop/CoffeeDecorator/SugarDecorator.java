package com.example.multithreadingProject.CoffeeShop.CoffeeDecorator;

import com.example.multithreadingProject.CoffeeShop.Coffee.Coffee;

public class SugarDecorator extends CoffeeDecorator{
    private final Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + sugar";
    }

    @Override
    public Double getCost() {
        return coffee.getCost() + 1.50;
    }
}
