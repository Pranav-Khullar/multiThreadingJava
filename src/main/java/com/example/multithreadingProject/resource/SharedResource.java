package com.example.multithreadingProject.resource;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isPresent = false;

    public synchronized void addItem() {
        isPresent = true;
        System.out.println("Producer thread calling the notify all function");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("Consumer thread inside consume item function");
        while(!isPresent) {
            try {
                System.out.println("Consumer thread is waiting");
                wait();
            } catch (Exception e) {
                // some exception handling
            }
        }

        System.out.println("Consumer thread consumes item");
        isPresent = false;
    }

    public synchronized void produce() {
        System.out.println("lock acquired");
        isPresent = true;
        try{
            Thread.sleep(5000);
        } catch (Exception e) {
            // handle exception
        }

        System.out.println("Lock released");
    }

    public void nonSyncProduce(ReentrantLock reentrantLock) {
        try {
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + " acquired reentrant lock!!");
            isPresent = true;
            Thread.sleep(4000);
        } catch (Exception e) {
            // handle exception
        } finally {
            isPresent = false;
            System.out.println(Thread.currentThread().getName() + " released reentrant lock!!");
            reentrantLock.unlock();
        }
    }

}
