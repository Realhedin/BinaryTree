package com.company.concurrency.java8concurrencyWinterbeTutorial.part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author dkorolev
 *         Date: 5/31/2019
 *         Time: 1:27 PM
 */
public class ExecutorsExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //ExecutorService takes Runnable, which doesn't return any value
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Hello, " + name);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }
        };
        executorService.submit(task);

        //to finish thread, we need to shutdown ExecutorService
        closeExecutor(executorService);


    }

    public static void closeExecutor(ExecutorService executorService) {
        try {
            System.out.println("try to terminate executor service");
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {

        } finally {
            if (!executorService.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}