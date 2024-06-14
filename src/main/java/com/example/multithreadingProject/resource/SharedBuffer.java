package com.example.multithreadingProject.resource;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> sharedBuffer;
    private final Integer bufferSize;

    public SharedBuffer(int bufferSize) {
        this.sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int a) {
        // bufferSize is full
        if (sharedBuffer.size() == bufferSize) {
            System.out.println("Producer thread going in wait state as buffer is full");
            try {
                wait();
            } catch (Exception e) {
                //
            }
        }

        System.out.println("Producer thread produces item "+ a);
        sharedBuffer.add(a);

        // notify consumer that there are items to consume
        notify();

//        // buffer was empty before inserting this element so consumer is in waiting state and needs to be notified
//        if (sharedBuffer.size() == 1) {
//            System.out.println("Producer thread calling the notify all function");
//            notifyAll();
//        }
    }

    public synchronized int consume() {
        // buffer is empty consumer has to wait
        if (sharedBuffer.isEmpty()) {
            System.out.println("Consumer thread going to wait as buffer is empty");
            try {
                wait();
            } catch (Exception e) {
                //
            }
        }

        // consuming item
        int item = sharedBuffer.poll();
        System.out.println("Consumer thread consumes item " + item);

        // notify producer that there is space in buffer now
        notify();

        return item;

//        // if size becomes full -1 producer needs to be notified
//        if (sharedBuffer.size() == bufferSize - 1) {
//            System.out.println("Consumer thread calling notify all");
//            notifyAll();
//        }
    }
}
