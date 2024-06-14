package com.example.multithreadingProject.producerConsumer;

import com.example.multithreadingProject.resource.SharedResource;

public class JoinThreadApp {
    public static void main(String args[]) {
        System.out.println("Main thread started");
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 calling produce method!!");
            sharedResource.produce();
            System.out.println("Thread 1 finishes execution");
        });

        thread1.start();
        try {
            thread1.join();
        } catch (Exception e) {
            // handle exception
        }

        System.out.println("Main thread completes execution");

    }
}
