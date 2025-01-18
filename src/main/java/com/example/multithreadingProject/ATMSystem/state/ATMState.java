package com.example.multithreadingProject.ATMSystem.state;

import com.example.multithreadingProject.ATMSystem.model.Card;
import com.example.multithreadingProject.ATMSystem.model.TransactionType;
import com.example.multithreadingProject.ATMSystem.model.User;

public interface ATMState {

    void insertCard(User user, Card card);
    void authenticatePin(int pin);
    void selectOperation(TransactionType txnType);
    void displayBalance();
    void withdrawCash(Double amount);
    void removeCard();
}
