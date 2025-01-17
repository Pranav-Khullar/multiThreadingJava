package com.example.multithreadingProject.CoffeeShop.CoffeeDecorator;

import com.example.multithreadingProject.CoffeeShop.Coffee.Coffee;

public abstract class CoffeeDecorator implements Coffee {
    @Override
    public abstract String getDescription();

    @Override
    public abstract Double getCost();
}
