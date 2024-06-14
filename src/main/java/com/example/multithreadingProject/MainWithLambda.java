package com.example.multithreadingProject;

import com.example.multithreadingProject.resource.SharedResource;

public class MainWithLambda {
    public static void main(String args[]) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                //
            }
            sharedResource.addItem();
        });
        Thread consumerThread = new Thread(() -> {sharedResource.consumeItem();});

        producerThread.start();
        consumerThread.start();
    }

}
