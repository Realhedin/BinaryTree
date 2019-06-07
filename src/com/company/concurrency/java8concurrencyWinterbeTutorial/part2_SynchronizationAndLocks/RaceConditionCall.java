package com.company.concurrency.java8concurrencyWinterbeTutorial.part2_SynchronizationAndLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author dkorolev
 *         Date: 6/4/2019
 *         Time: 3:44 PM
 */
public class RaceConditionCall {

    public static void main(String[] args) {

        //call not synchronized method
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        CountClass countClass = new CountClass();
         IntStream.range(0, 100000)
            .forEach(i -> executorService.submit(countClass::increment));
        stop(executorService);
        System.out.println(countClass.getCount());

        //call to synchronized method
        ExecutorService executorService2 = Executors.newFixedThreadPool(9);
        CountClass countClass2 = new CountClass();
        IntStream intStream2 = IntStream.range(0, 100000);
        intStream2.forEach(i -> executorService2.submit(countClass2::syncIncrement));
        stop(executorService2);
        System.out.println(countClass2.getCount());


        //change synchronized increment to use locks
        ExecutorService executorService3 = Executors.newFixedThreadPool(3);
        CountClass countClass3 = new CountClass();
        IntStream.range(0, 100000)
                .forEach(i -> executorService3.submit(countClass3::incrementWithLock));
        RaceConditionCall.stop(executorService3);
        System.out.println(countClass3.getCount());

    }



    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}