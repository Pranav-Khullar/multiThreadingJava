package com.example.multithreadingProject.tasks;

import com.example.multithreadingProject.resource.SharedResource;

public class ConsumerTask implements Runnable{

    SharedResource sharedResource;
    public ConsumerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Consumer Thread: "+ Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
