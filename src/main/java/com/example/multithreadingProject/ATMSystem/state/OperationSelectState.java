package com.example.multithreadingProject.ATMSystem.state;

import com.example.multithreadingProject.ATMSystem.model.Atm;
import com.example.multithreadingProject.ATMSystem.model.Card;
import com.example.multithreadingProject.ATMSystem.model.TransactionType;
import com.example.multithreadingProject.ATMSystem.model.User;

public class OperationSelectState implements ATMState{
    private final Atm atm;

    public OperationSelectState(Atm atm) {
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
        atm.setTransactionType(txnType);
        if (txnType == TransactionType.WITHDRAW_CASH) {
            atm.setAtmState(atm.getCashWithdrawalState());
        } else if (txnType == TransactionType.DISPLAY_BALANCE) {
            atm.setAtmState(atm.getDisplayBalanceState());
        } else {
            System.out.println("Select a valid operation!!");
        }
    }

    @Override
    public void displayBalance() {
        System.out.println("Select an operation");
    }

    @Override
    public void withdrawCash(Double amount) {
        System.out.println("Select an operation");
    }

    @Override
    public void removeCard() {
        atm.setCard(null);
        atm.setUser(null);
        atm.setAtmState(atm.getIdleState());
    }
}
