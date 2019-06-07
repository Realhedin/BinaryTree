package com.company.concurrency.java8concurrencyWinterbeTutorial.part1_ThreadsAndExecutors;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author dkorolev
 *         Date: 5/31/2019
 *         Time: 2:27 PM
 */
public class ExecutorsCallableFutureExample {

    public static void main(String[] args) {

        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(4);
            return 123;
        };

        Callable<Integer> task2 = () -> {
            TimeUnit.SECONDS.sleep(2);
            return 246;
        };

        System.out.println("Time Start: " + LocalTime.now());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executorService.submit(task);
        Future<Integer> future2 = executorService.submit(task2);

        System.out.println("Future is done? " + future1.isDone());

        Integer result1 = null;
        Integer result2 = null;
        try {
            result1 = future1.get(5, TimeUnit.SECONDS);
            result2 = future2.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception in Callable");
        } catch (ExecutionException e) {
            System.err.println("ExecutionException in Callable");
        } catch (TimeoutException e) {

        }


        System.out.println("Future is done? " + future1.isDone());
        System.out.println("Result: " + result1);
        System.out.println("Result2: " + result2);

        ExecutorsExample.closeExecutor(executorService);

        System.out.println("Time Finish: " + LocalTime.now());
    }
}