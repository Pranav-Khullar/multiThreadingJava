package com.example.multithreadingProject.producerConsumer;

import com.example.multithreadingProject.resource.SharedResource;

// Daemon thread is an async thread which keeps on running till there is even 1 user thread running
// Auto save, logging and garbage collector are examples of daemon thread
public class DaemonThreadMain {
    public static void main(String args[]) {
        SharedResource sharedResource = new SharedResource();
        System.out.println("Main thread started");

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            sharedResource.produce();
            System.out.println("Thread 1 finished execution");
        });

        // if we do not set daemon then thread 1 runs completely waits for 5 secs and releases lock
        // but if it is set daemon then as soon as main finishes thread1 also ends execution
        thread1.setDaemon(true);
        thread1.start();

        System.out.println("Main thread finished execution");
    }
}
