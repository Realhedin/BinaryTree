package com.company.concurrency.java8concurrencyWinterbeTutorial.part2_SynchronizationAndLocks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dkorolev
 *         Date: 6/4/2019
 *         Time: 3:43 PM
 */
public class CountClass {

    private  int count = 0;

    public  void increment() {
        count += 1;
    }

    public  synchronized void syncIncrement() {
        count += 1;
    }


    ReentrantLock reentrantLock = new ReentrantLock();
    public void incrementWithLock() {
        reentrantLock.lock();
        try {
            count += 1;
        } finally {
            reentrantLock.unlock();
        }
    }



    public  int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}