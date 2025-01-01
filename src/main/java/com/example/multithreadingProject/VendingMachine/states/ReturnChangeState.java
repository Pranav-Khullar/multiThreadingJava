package com.example.multithreadingProject.VendingMachine.states;

import com.example.multithreadingProject.VendingMachine.model.Coin;
import com.example.multithreadingProject.VendingMachine.model.Note;
import com.example.multithreadingProject.VendingMachine.model.VendingMachine;

public class ReturnChangeState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String productName) {
        System.out.println("Product already selected");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment has already been made.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment has already been made.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product has already been dispensed");
    }

    @Override
    public void returnChange() {
        Double change = vendingMachine.getPayment() - vendingMachine.getProduct().getPrice();
        vendingMachine.setPayment(0.0);
        System.out.println("Returning change: $" + change);
        vendingMachine.setVendingMachineState(vendingMachine.getIdleState());
    }
}
