package com.company;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dkorolev
 *         Date: 2/1/2019
 *         Time: 7:03 PM
 */
public class ConcurrentHelperMethods {

    ReentrantLock lock = new ReentrantLock();

    int count = 0;

     void increment() {
        count = count + 1;
    }

    synchronized void incrementSync() {
        count = count + 1;
    }

    void incrementSyncBlock() {
        synchronized (this) {
            count = count + 1;
        }
    }

    void incrementReentrantLock() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

}