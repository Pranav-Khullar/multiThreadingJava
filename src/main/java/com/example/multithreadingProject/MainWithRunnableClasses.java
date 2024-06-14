package com.example.multithreadingProject;

import com.example.multithreadingProject.resource.SharedResource;
import com.example.multithreadingProject.tasks.ConsumerTask;
import com.example.multithreadingProject.tasks.ProducerTask;

public class MainWithRunnableClasses {
    public static void main(String args[]) {
        System.out.println("Main method start");

        SharedResource sharedResource = new SharedResource();

        // producer thread
        Thread producerThread = new Thread(new ProducerTask(sharedResource));

        // consumer thread
        Thread consumerThread = new Thread(new ConsumerTask(sharedResource));

        producerThread.start();
        consumerThread.start();

        System.out.println("Main method end");
    }

}
