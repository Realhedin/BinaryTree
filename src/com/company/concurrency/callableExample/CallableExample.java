package com.company.concurrency.callableExample;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dkorolev
 *         Date: 5/23/2019
 *         Time: 6:23 PM
 */
public class CallableExample {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Set<Future<Integer>> futureSet = new HashSet<>();
        for (String word : args) {
            Callable<Integer> callable = new WordLengthCallable(word);
            Future<Integer> future = threadPool.submit(callable);
            futureSet.add(future);
        }
        int sum =0;
        for (Future<Integer> future : futureSet) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {

            } catch (ExecutionException e) {

            }
        }
        System.out.println("The sum: " + sum);
//        System.exit(sum);
        if (!threadPool.isShutdown()) {
            threadPool.shutdown();
        }
    }


}