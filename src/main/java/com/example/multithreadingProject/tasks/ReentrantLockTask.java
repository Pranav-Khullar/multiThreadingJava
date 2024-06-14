package com.example.multithreadingProject.tasks;

import com.example.multithreadingProject.resource.SharedResource;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTask implements Runnable{

    private final ReentrantLock reentrantLock;
    private final SharedResource sharedResource;

    public ReentrantLockTask(ReentrantLock reentrantLock, SharedResource sharedResource) {
        this.reentrantLock = reentrantLock;
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.nonSyncProduce(reentrantLock);
    }
}
