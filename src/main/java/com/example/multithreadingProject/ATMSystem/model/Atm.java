package com.example.multithreadingProject.ATMSystem.model;

import com.example.multithreadingProject.ATMSystem.state.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Atm {
    private User user;
    private Card card;
    private ATMState atmState;
    private final IdleState idleState;
    private final HasCardState hasCardState;
    private final OperationSelectState operationSelectState;
    private TransactionType transactionType;
    private final CashWithdrawalState cashWithdrawalState;
    private final DisplayBalanceState displayBalanceState;
    private final RemoveCardState removeCardState;

    public Atm() {
        idleState = new IdleState(this);
        hasCardState = new HasCardState(this);
        operationSelectState = new OperationSelectState(this);
        cashWithdrawalState = new CashWithdrawalState(this);
        displayBalanceState = new DisplayBalanceState(this);
        removeCardState = new RemoveCardState(this);
        atmState = this.idleState;
        user = null;
        card = null;
        transactionType = null;
    }

    public void insertCard(User user, Card card) {
        atmState.insertCard(user, card);
    }

    public void authenticate(int pin) {
        atmState.authenticatePin(pin);
    }

    public void selectTransactionType(TransactionType transactionType) {
        atmState.selectOperation(transactionType);
    }

    public void displayBalance() {
        atmState.displayBalance();
    }

    public void withdrawCash(Double amount) {
        atmState.withdrawCash(amount);
    }

    public void removeCard() {
        atmState.removeCard();
    }
}
