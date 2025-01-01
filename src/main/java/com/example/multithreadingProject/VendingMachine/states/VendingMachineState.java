package com.example.multithreadingProject.VendingMachine.states;

import com.example.multithreadingProject.VendingMachine.model.Coin;
import com.example.multithreadingProject.VendingMachine.model.Note;
import com.example.multithreadingProject.VendingMachine.model.Product;

public interface VendingMachineState {

    void selectProduct(String productName);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
}
