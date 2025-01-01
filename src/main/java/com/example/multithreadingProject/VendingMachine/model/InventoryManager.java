package com.example.multithreadingProject.VendingMachine.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryManager {
    private Map<String, Product> inventoryMap;

    public InventoryManager() {
        this.inventoryMap = new ConcurrentHashMap<>();
    }

    public void addProduct(String productName, Product product) {
        inventoryMap.put(productName, product);
    }

    public Boolean checkInventory(String productName) {
        return inventoryMap.get(productName).getQuantity() > 0;
    }

    public void restockProduct(String productName, Integer quantity) {
        inventoryMap.get(productName).incrementQuantity(quantity);
    }

    public void dispenseProduct(String productName) {
        inventoryMap.get(productName).decrementQuantity();
    }

    public Map<String, Product> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(Map<String, Product> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }
}
