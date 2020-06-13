package com.company.concurrency.shipilev.javapragmatic;

import com.company.concurrency.java8concurrencyWinterbeTutorial.part2_SynchronizationAndLocks.RaceConditionCall;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Examples {

    public static void main(String[] args) {

        //we have: int x, volatile int g
        //thread1 executes: x=1; g=1;
        //thread2 executes: r1=g; r2=x
        //Possible results: 0:0, 1:1, 0:1
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        HappensBeforeClass happensBeforeClass = new HappensBeforeClass();
        IntStream.range(0,100000)
                .forEach(i -> {
                    clearVariables(happensBeforeClass);
                    executorService.submit(happensBeforeClass::settingFunction);
                    executorService.submit(happensBeforeClass::gettingFunction);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        RaceConditionCall.stop(executorService);
    }

    private static void clearVariables(HappensBeforeClass happensBeforeClass) {
        Thread thread = new Thread(() -> {
            happensBeforeClass.g = 0;
            happensBeforeClass.x = 0;
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
