package com.example.multithreadingProject.ATMSystem.state;

import com.example.multithreadingProject.ATMSystem.model.Atm;
import com.example.multithreadingProject.ATMSystem.model.Card;
import com.example.multithreadingProject.ATMSystem.model.TransactionType;
import com.example.multithreadingProject.ATMSystem.model.User;

public class CashWithdrawalState implements ATMState{
    private final Atm atm;

    public CashWithdrawalState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(User user, Card card) {
        System.out.println("Card already inserted!!");
    }

    @Override
    public void authenticatePin(int pin) {
        System.out.println("Already authenticated!!");
    }

    @Override
    public void selectOperation(TransactionType txnType) {
        System.out.println("Operation already selected");
    }

    @Override
    public void displayBalance() {
        System.out.println("Operation not selected");
    }

    @Override
    public void withdrawCash(Double amount) {
        if (atm.getUser().getBalance() < amount) {
            System.out.println("Insufficient balance!! Enter valid amount. Current balance: " + atm.getUser().getBalance());
        }
        else {
            atm.getUser().setBalance(atm.getUser().getBalance() - amount);
            System.out.println("Amount withdrawn: " + amount);
            atm.setAtmState(atm.getRemoveCardState());
        }
    }

    @Override
    public void removeCard() {
        atm.setCard(null);
        atm.setUser(null);
        atm.setAtmState(atm.getIdleState());
    }
}
