package com.example.multithreadingProject.ATMSystem.state;

import com.example.multithreadingProject.ATMSystem.model.Atm;
import com.example.multithreadingProject.ATMSystem.model.Card;
import com.example.multithreadingProject.ATMSystem.model.TransactionType;
import com.example.multithreadingProject.ATMSystem.model.User;

public class IdleState implements ATMState{
    private final Atm atm;

    public IdleState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(User user, Card card) {
        atm.setCard(card);
        atm.setUser(user);
        atm.setAtmState(atm.getHasCardState());
    }

    @Override
    public void authenticatePin(int pin) {
        System.out.println("Insert card first");
    }

    @Override
    public void selectOperation(TransactionType txnType) {
        System.out.println("Insert card first");
    }

    @Override
    public void displayBalance() {
        System.out.println("Insert card first");
    }

    @Override
    public void withdrawCash(Double amount) {
        System.out.println("Insert card first");
    }

    @Override
    public void removeCard() {
        System.out.println("No card inserted");
    }
}
