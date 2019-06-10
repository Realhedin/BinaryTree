package com.company.concurrency.java8concurrencyWinterbeTutorial.part3_AtomicAndConcurrentMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

import com.company.concurrency.java8concurrencyWinterbeTutorial.part2_SynchronizationAndLocks.RaceConditionCall;

/**
 * @author dkorolev
 *         Date: 6/7/2019
 *         Time: 6:59 PM
 */
public class LongAdderExample {
    public static void main(String[] args) {

        //LongAdderExample is alternative to AtomicLong with better throughput under high contention
        //but on the other hand - consumes higher memory
        System.out.println("LongAdder:");
        LongAdder longAdder = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0,10000)
                .forEach(i-> executorService.submit(longAdder::increment));

        RaceConditionCall.stop(executorService);
        System.out.println(longAdder.sumThenReset());
        System.out.println(longAdder.sumThenReset());


        //LongAccumulator example
        System.out.println("LongAccumulator:");
        //x - current, y - input value
        LongBinaryOperator op = (x,y) -> 2 * x + y;
        LongAccumulator longAccumulator2 = new LongAccumulator(op, 1L);
        ExecutorService executorService2 = Executors.newFixedThreadPool(1);
        IntStream.range(0,5)
                .forEach(i -> executorService2.submit(() -> longAccumulator2.accumulate(i)));
        RaceConditionCall.stop(executorService2);
        System.out.println(longAccumulator2.getThenReset());


    }
}