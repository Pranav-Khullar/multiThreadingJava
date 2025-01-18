package com.example.multithreadingProject.ATMSystem.state;

import com.example.multithreadingProject.ATMSystem.model.Atm;
import com.example.multithreadingProject.ATMSystem.model.Card;
import com.example.multithreadingProject.ATMSystem.model.TransactionType;
import com.example.multithreadingProject.ATMSystem.model.User;

public class RemoveCardState implements ATMState{
    private final Atm atm;

    public RemoveCardState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(User user, Card card) {
        System.out.println("Session completed. Please remove card.");
    }

    @Override
    public void authenticatePin(int pin) {
        System.out.println("Session completed. Please remove card.");
    }

    @Override
    public void selectOperation(TransactionType txnType) {
        System.out.println("Session completed. Please remove card.");
    }

    @Override
    public void displayBalance() {
        System.out.println("Session completed. Please remove card.");
    }

    @Override
    public void withdrawCash(Double amount) {
        System.out.println("Session completed. Please remove card.");
    }

    @Override
    public void removeCard() {
        atm.setCard(null);
        atm.setUser(null);
        atm.setAtmState(atm.getIdleState());
    }
}
