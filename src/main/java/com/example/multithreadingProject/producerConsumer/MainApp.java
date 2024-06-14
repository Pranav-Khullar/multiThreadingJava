package com.example.multithreadingProject.producerConsumer;

import com.example.multithreadingProject.resource.SharedBuffer;

public class MainApp {
    public static void main(String args[]) {
        System.out.println("Main method start");

        SharedBuffer sharedBuffer = new SharedBuffer(5);

        Thread producerThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                //
            }
            for (int i=0; i<10; i++) {
                sharedBuffer.produce(i);
            }
        });
        Thread consumerThread = new Thread(() -> {
            for (int i=0; i<10; i++) {
                sharedBuffer.consume();
            }
        });


        producerThread.start();
        consumerThread.start();

        System.out.println("Main method end");
    }
}
