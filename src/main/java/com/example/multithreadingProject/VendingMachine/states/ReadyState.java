package com.example.multithreadingProject.VendingMachine.states;

import com.example.multithreadingProject.VendingMachine.model.Coin;
import com.example.multithreadingProject.VendingMachine.model.Note;
import com.example.multithreadingProject.VendingMachine.model.VendingMachine;

public class ReadyState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String productName) {
        System.out.println("Product already selected. Please make payment.");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        if (vendingMachine.getPayment() >= vendingMachine.getProduct().getPrice()) {
            vendingMachine.setVendingMachineState(vendingMachine.getDispenseState());
        }
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        if (vendingMachine.getPayment() >= vendingMachine.getProduct().getPrice()) {
            vendingMachine.setVendingMachineState(vendingMachine.getDispenseState());
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first");
    }

    @Override
    public void returnChange() {
        System.out.println("No amount to return");
    }
}
