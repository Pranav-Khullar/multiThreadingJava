package com.example.multithreadingProject.producerConsumer;

import com.example.multithreadingProject.resource.SharedResource;
import com.example.multithreadingProject.tasks.ReentrantLockTask;

import java.util.concurrent.locks.ReentrantLock;

/**
 * We pass an instance of reentrant lock with all threads so that even if separate objects of resource are being used we
 * can use the reentrant lock to make sure that a certain method is only executed by one thread irrespective of object
 */
public class ReentrantLockMain {
    public static void main(String args[]) {
        System.out.println("Main thread starts");

        ReentrantLock reentrantLock = new ReentrantLock();

        SharedResource sharedResource1 = new SharedResource();
        Thread thread1 = new Thread(() -> {
            sharedResource1.nonSyncProduce(reentrantLock);
        });

        SharedResource sharedResource2 = new SharedResource();
        Thread thread2 = new Thread(() -> {
            sharedResource2.nonSyncProduce(reentrantLock);
        });

        SharedResource sharedResource3 = new SharedResource();
        Thread thread3 = new Thread(new ReentrantLockTask(reentrantLock, sharedResource3));

        thread1.start();
        thread2.start();
        thread3.start();

//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//        } catch (Exception e) {
//            // handle exception
//        }

        System.out.println("Main thread finishes execution");
    }
}
