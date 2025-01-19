package com.example.multithreadingProject.WeightMachineAdapter.adapter;

import com.example.multithreadingProject.WeightMachineAdapter.weightMachine.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdaptor{
    private final WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public Double getWeightInKg() {
        Double weightInPounds = weightMachine.getWeightInPounds();
        return weightInPounds * 0.45;
    }
}
