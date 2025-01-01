package com.example.multithreadingProject.VendingMachine.model;

import com.example.multithreadingProject.VendingMachine.states.*;

import java.util.Map;

public class VendingMachine {
    private static VendingMachine instance;
    private VendingMachineState vendingMachineState;
    private Product product;
    private Double payment;
    private InventoryManager inventoryManager;
    private IdleState idleState;
    private ReadyState readyState;
    private DispenseState dispenseState;
    private ReturnChangeState returnChangeState;

    public VendingMachine() {
        this.idleState = new IdleState(this);
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this);
        this.returnChangeState = new ReturnChangeState(this);
        this.vendingMachineState = idleState;
        this.inventoryManager = new InventoryManager();
        this.payment = 0.0;
    }

    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void selectProduct(String productName) {
        vendingMachineState.selectProduct(productName);
    }

    public void insertCoin(Coin coin) {
        vendingMachineState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        vendingMachineState.insertNote(note);
    }

    public void dispenseProduct() {
        vendingMachineState.dispenseProduct();
    }

    public void returnChange() {
        vendingMachineState.returnChange();
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public IdleState getIdleState() {
        return idleState;
    }

    public void setIdleState(IdleState idleState) {
        this.idleState = idleState;
    }

    public ReadyState getReadyState() {
        return readyState;
    }

    public void setReadyState(ReadyState readyState) {
        this.readyState = readyState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public ReturnChangeState getReturnChangeState() {
        return returnChangeState;
    }

    public void setReturnChangeState(ReturnChangeState returnChangeState) {
        this.returnChangeState = returnChangeState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public void setInventoryManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void addCoin(Coin coin) {
        payment += coin.getValue();
    }

    public void addNote(Note note) {
        payment += note.getValue();
    }
}
