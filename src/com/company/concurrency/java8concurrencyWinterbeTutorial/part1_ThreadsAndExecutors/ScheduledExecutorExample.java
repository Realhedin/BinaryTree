package com.company.concurrency.java8concurrencyWinterbeTutorial.part1_ThreadsAndExecutors;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author dkorolev
 *         Date: 6/3/2019
 *         Time: 4:30 PM
 */
public class ScheduledExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        //run with delay
        Runnable task = () -> System.out.println("Scheduling: " + LocalDateTime.now());
        ScheduledFuture<?> future = executorService.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.println("Remaining delay: " + remainingDelay);


        //run with periodical job
        Runnable task2 = () -> System.out.println("Scheduling: " + LocalDateTime.now());

        int initialDelay = 0;
        int period = 1;
        executorService.scheduleAtFixedRate(task2, initialDelay, period, TimeUnit.SECONDS);

        Thread.sleep(8000);
        ExecutorsExample.closeExecutor(executorService);



        //run with fixed delay (for case when task execution time you cannot predict)
        executorService = Executors.newScheduledThreadPool(1);
        System.out.println("\n");
        Runnable task3 = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + LocalDateTime.now());
            }
            catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        executorService.scheduleWithFixedDelay(task3, initialDelay, period, TimeUnit.SECONDS);
        Thread.sleep(8000);
        ExecutorsExample.closeExecutor(executorService);

    }
}