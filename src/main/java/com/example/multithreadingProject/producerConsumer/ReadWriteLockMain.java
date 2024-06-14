package com.example.multithreadingProject.producerConsumer;

import com.example.multithreadingProject.resource.SharedReadWriteResource;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMain {
    public static void main(String args[]) {
        System.out.println("Main thread starts!!");
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        SharedReadWriteResource sharedReadWriteResource1 = new SharedReadWriteResource();
        Thread thread1 = new Thread(() -> {
            sharedReadWriteResource1.read(readWriteLock);
        });

        SharedReadWriteResource sharedReadWriteResource2 = new SharedReadWriteResource();
        Thread thread2 = new Thread(() -> {
            sharedReadWriteResource2.read(readWriteLock);
        });

        SharedReadWriteResource sharedReadWriteResource3 = new SharedReadWriteResource();
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                sharedReadWriteResource3.write(readWriteLock);
            } catch (Exception e) {
                // handle exception
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Main thread finishes execution");
    }
}
