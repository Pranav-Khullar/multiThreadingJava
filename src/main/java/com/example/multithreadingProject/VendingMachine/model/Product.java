package com.example.multithreadingProject.VendingMachine.model;

public class Product {
    private final String name;
    private final Double price;
    private Integer quantity = 0;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity(Integer quantity) {
        this.quantity += quantity;
    }

    public void decrementQuantity() {
        this.quantity--;
    }
}
