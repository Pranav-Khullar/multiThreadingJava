package com.example.multithreadingProject.resource;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedReadWriteResource {

    Boolean isAvailable = false;

    public void read(ReadWriteLock readWriteLock) {
        try {
            readWriteLock.readLock().lock();
            System.out.println("Read lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {
            // handle exception
        } finally {
            System.out.println("Read lock released by " + Thread.currentThread().getName());
            readWriteLock.readLock().unlock();
        }
    }

    public void write(ReadWriteLock readWriteLock) {
        try {
            readWriteLock.writeLock().lock();
            System.out.println("Write lock acquired by " + Thread.currentThread().getName());
            isAvailable = true;
        } catch (Exception e) {
            // handle exception
        } finally {
            System.out.println("Write lock released by " + Thread.currentThread().getName());
            readWriteLock.writeLock().unlock();
        }
    }
}
