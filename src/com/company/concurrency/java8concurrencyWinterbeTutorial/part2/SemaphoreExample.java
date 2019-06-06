package com.company.concurrency.java8concurrencyWinterbeTutorial.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author dkorolev
 *         Date: 6/6/2019
 *         Time: 3:31 PM
 */
public class SemaphoreExample {
    public static void main(String[] args) {

        //Semaphone usefull when we don't need exclusive lock
        //but would like to limit number of concurrent threads to some resource
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(5);


        Runnable task = (() -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println("Permit in Semaphore acquired. Left: " + semaphore.availablePermits());
                    RaceConditionCall.sleep(5);
                } else {
                    System.out.println("All permits are already taken!");
                }
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted");
            } finally {
                if (permit) {
                    semaphore.release();
                }
            }
        });

        IntStream.range(1, 10)
                .forEach(i -> executorService.submit(task));
        RaceConditionCall.stop(executorService);

    }
}