package com.company.concurrency.java8concurrencyWinterbeTutorial.part2_SynchronizationAndLocks;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author dkorolev
 *         Date: 6/5/2019
 *         Time: 12:35 PM
 */
public class LockExample {
    public static void main(String[] args) {

        //check lock status with ReentrantLock
        System.out.println("Reentrant lock:");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ReentrantLock reentrantLock = new ReentrantLock();

        executorService.submit(() -> {
                    reentrantLock.lock();
                    try {
                        RaceConditionCall.sleep(1);
                    } finally {
                        reentrantLock.unlock();
                    }
                }
        );

        executorService.submit(() -> {
            System.out.println("Locked: " + reentrantLock.isLocked());
            System.out.println("held by me: " + reentrantLock.isHeldByCurrentThread());
            boolean locked = reentrantLock.tryLock();      //will get lock only if it's not taken
            System.out.println("Lock acquired: "+ locked);
            reentrantLock.lock();                          //will wait for lock and get it
            locked = reentrantLock.tryLock();
            System.out.println("Lock acquired: "+ locked);
            System.out.println("held by me: " + reentrantLock.isHeldByCurrentThread());
            reentrantLock.unlock();
                }
        );

        RaceConditionCall.stop(executorService);



        //ReentrantReadWrite lock
        System.out.println("\nReentrantReadWrite lock:");
        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Map<String, String> map = new HashMap<>();

        executorService1.submit(() -> {
            reentrantReadWriteLock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
                RaceConditionCall.sleep(1);
                map.put("foo", "bar");
                System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
        });

        Runnable task = () -> {
            reentrantReadWriteLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
                //here we wait until writeLock.unlock(), only afterwards we continue
                //but they don't need to wait readLock, they can access simultaneously
                System.out.println(map.get("foo"));
                System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
                RaceConditionCall.sleep(1);
            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        };

        executorService1.submit(task);
        executorService1.submit(task);

        RaceConditionCall.stop(executorService1);



        //Stamped lock  (same logic as above)  NO reentrant locks
        System.out.println("\nStamped lock:");
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
        StampedLock stampedLock = new StampedLock();
        Map<String, String> map2 = new HashMap<>();

        executorService2.submit(() -> {
            long stamp = stampedLock.writeLock();
            try {
                System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
                RaceConditionCall.sleep(1);
                map2.put("foo", "bar");
                System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
            } finally {
                stampedLock.unlockWrite(stamp);
            }
        });

        Runnable task2 = () -> {
            long stamp = stampedLock.readLock();
            try {
                System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
                //here we wait until writeLock.unlock(), only afterwards we continue
                //but they don't need to wait readLock, they can access simultaneously
                System.out.println(map2.get("foo"));
                System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
                RaceConditionCall.sleep(1);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        };

        executorService2.submit(task2);
        executorService2.submit(task2);

        RaceConditionCall.stop(executorService2);



        //optimistic locking example
        System.out.println("\nOptimistic lock");
        ExecutorService executorService3 = Executors.newFixedThreadPool(3);
        StampedLock stampedLock3 = new StampedLock();

        executorService3.submit(() -> {
            long stamp = stampedLock3.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock valid: " + stampedLock3.validate(stamp));
                RaceConditionCall.sleep(1);
                System.out.println("Optimistic Lock valid: " + stampedLock3.validate(stamp));
                RaceConditionCall.sleep(2);
                System.out.println("Optimistic Lock valid: " + stampedLock3.validate(stamp));
            } finally {
                stampedLock3.unlock(stamp);
            }
        });


        executorService3.submit(() -> {
            //we don't need to wait for unlock optimisticRead,
            //we can take writeLock immediately
            long stamp = stampedLock3.writeLock();
            try {
                System.out.println("Write Lock acquired");
                RaceConditionCall.sleep(2);
            } finally {
                stampedLock3.unlock(stamp);
                System.out.println("Write done");
            }
        });

        RaceConditionCall.stop(executorService3);



        //convertation example
        System.out.println("\nConvertation example:");
        ExecutorService executorService4 = Executors.newFixedThreadPool(3);
        StampedLock stampedLock4 = new StampedLock();
        CountClass countClass4 = new CountClass();
        countClass4.setCount(1);

        executorService4.submit(() -> {
            long stamp = stampedLock4.readLock();
            try {
                if (countClass4.getCount() == 0) {
                    long convStamp = stampedLock4.tryConvertToWriteLock(stamp);
                    if (convStamp == 0L) {
                        System.err.println("Could not convert to write lock");
                        convStamp = stampedLock4.writeLock();
                    }
                    countClass4.setCount(23);
                }
                System.out.println(countClass4.getCount());
            } finally {
                stampedLock4.unlock(stamp);
            }
        });
        RaceConditionCall.stop(executorService4);

    }
}