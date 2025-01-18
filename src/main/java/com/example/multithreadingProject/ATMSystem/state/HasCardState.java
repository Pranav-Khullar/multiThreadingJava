package com.example.multithreadingProject.ATMSystem.state;

import com.example.multithreadingProject.ATMSystem.model.Atm;
import com.example.multithreadingProject.ATMSystem.model.Card;
import com.example.multithreadingProject.ATMSystem.model.TransactionType;
import com.example.multithreadingProject.ATMSystem.model.User;

public class HasCardState implements ATMState {
    private final Atm atm;

    public HasCardState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(User user, Card card) {
        System.out.println("Card already inserted!!");
    }

    @Override
    public void authenticatePin(int pin) {
        if(pin == atm.getCard().getPin()) {
            System.out.println("Authentication successful");
            atm.setAtmState(atm.getOperationSelectState());
        } else {
            System.out.println("Wrong pin!! Try Again.");
        }
    }

    @Override
    public void selectOperation(TransactionType txnType) {
        System.out.println("Authenticate first");
    }

    @Override
    public void displayBalance() {
        System.out.println("Authenticate first");
    }

    @Override
    public void withdrawCash(Double amount) {
        System.out.println("Authenticate first");
    }

    @Override
    public void removeCard() {
        atm.setCard(null);
        atm.setUser(null);
        atm.setAtmState(atm.getIdleState());
    }
}
