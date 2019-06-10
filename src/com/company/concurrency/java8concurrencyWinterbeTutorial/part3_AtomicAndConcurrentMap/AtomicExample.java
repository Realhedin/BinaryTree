package com.company.concurrency.java8concurrencyWinterbeTutorial.part3_AtomicAndConcurrentMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import com.company.concurrency.java8concurrencyWinterbeTutorial.part2_SynchronizationAndLocks.RaceConditionCall;

/**
 * @author dkorolev
 *         Date: 6/7/2019
 *         Time: 11:28 AM
 */
public class AtomicExample {
    public static void main(String[] args) {

        //atomic operations are thread-safe
        System.out.println("IncrementAndGet:");
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0,10000)
                .forEach(i-> executorService.submit(atomicInteger::incrementAndGet));
        RaceConditionCall.stop(executorService);
        System.out.println(atomicInteger.get());


        //thread-safe update
        System.out.println("UpdateAndGet operation:");
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);

        IntStream.range(0,10000)
                .forEach(i -> {
                    Runnable task = () -> atomicInteger2.updateAndGet(n->n+2);
                    executorService2.submit(task);
                });
        RaceConditionCall.stop(executorService2);
        System.out.println(atomicInteger2.get());


        //thread-safe function
        System.out.println("AccumulateAndGet operation:");
        AtomicInteger atomicInteger3 = new AtomicInteger(0);
        ExecutorService executorService3 = Executors.newFixedThreadPool(3);

        IntStream.range(0,10000)
                .forEach(i -> {
                    Runnable task = () -> atomicInteger3.accumulateAndGet(i, (n, m)-> n+m);
                    executorService3.submit(task);
                });
        RaceConditionCall.stop(executorService3);
        System.out.println(atomicInteger3.get());




    }
}