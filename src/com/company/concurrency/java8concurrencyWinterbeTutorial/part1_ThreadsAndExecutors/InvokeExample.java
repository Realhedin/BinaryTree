package com.company.concurrency.java8concurrencyWinterbeTutorial.part1_ThreadsAndExecutors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author dkorolev
 *         Date: 6/3/2019
 *         Time: 11:24 AM
 */
public class InvokeExample {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        //invokeAll example
        List<Future<String>> futures = executorService.invokeAll(callables);
        System.out.println("invokeAll:");
        futures.stream()
                .map(future -> {
                    try {
                        return future.get(2, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);


        //invokeAny example
        System.out.println();
        String result;
        try {
            result = executorService.invokeAny(callables);
            System.out.println(result);
            result = executorService.invokeAny(callables);
            System.out.println(result);
        } catch (ExecutionException e) {

        }


    }
}