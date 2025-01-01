package com.example.multithreadingProject.VendingMachine.states;

import com.example.multithreadingProject.VendingMachine.model.Coin;
import com.example.multithreadingProject.VendingMachine.model.Note;
import com.example.multithreadingProject.VendingMachine.model.Product;
import com.example.multithreadingProject.VendingMachine.model.VendingMachine;

public class IdleState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String productName) {
        if (vendingMachine.getInventoryManager().checkInventory(productName)) {
            vendingMachine.setProduct(vendingMachine.getInventoryManager().getInventoryMap().get(productName));
            vendingMachine.setVendingMachineState(vendingMachine.getReadyState());
            System.out.println("Product selected: " + productName);
        } else {
            System.out.println("Product out of stock. Please select some other product.");
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first.");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return.");
    }
}
