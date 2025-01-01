package com.example.multithreadingProject.VendingMachine.states;

import com.example.multithreadingProject.VendingMachine.model.Coin;
import com.example.multithreadingProject.VendingMachine.model.Note;
import com.example.multithreadingProject.VendingMachine.model.VendingMachine;

public class DispenseState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String productName) {
        System.out.println("Product already selected");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already received");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment already received");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.getInventoryManager().dispenseProduct(vendingMachine.getProduct().getName());
        System.out.println("Dispensing product: " + vendingMachine.getProduct().getName());
        vendingMachine.setVendingMachineState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Dispensing product. Will return change after product has been dispensed");
    }
}
