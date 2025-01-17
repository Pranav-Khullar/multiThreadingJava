package com.example.multithreadingProject.CoffeeShop;

import com.example.multithreadingProject.CoffeeShop.Coffee.Cappuccino;
import com.example.multithreadingProject.CoffeeShop.CoffeeDecorator.CoffeeDecorator;
import com.example.multithreadingProject.CoffeeShop.CoffeeDecorator.MilkDecorator;
import com.example.multithreadingProject.CoffeeShop.CoffeeDecorator.SugarDecorator;

public class CoffeeShopApplication {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino();
        CoffeeDecorator coffeeDecorator = new MilkDecorator(new SugarDecorator(cappuccino));
        System.out.println(coffeeDecorator.getDescription());
        System.out.println(coffeeDecorator.getCost());
    }
}
