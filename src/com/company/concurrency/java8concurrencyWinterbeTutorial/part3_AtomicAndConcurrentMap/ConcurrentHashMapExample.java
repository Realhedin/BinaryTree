package com.company.concurrency.java8concurrencyWinterbeTutorial.part3_AtomicAndConcurrentMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * @author dkorolev
 *         Date: 6/11/2019
 *         Time: 4:07 PM
 */
public class ConcurrentHashMapExample {
    public static void main(String[] args) {

        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        System.out.println("\nforEach:");
       map.forEach(1, (key, value) ->
               System.out.printf("key: %s, value: %s, thread:%s\n",
                       key, value, Thread.currentThread().getName()));


        System.out.println("\nSearch:");
        String resultOfSearch = map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if ("foo".equals(key)) {
                return value;
            }
            return null;
        });
        System.out.println(resultOfSearch);

        System.out.println("\nsearchValues:");
        String s = map.searchValues(1, value -> {
            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return value;
            }
            return null;
        });
        System.out.println(s);


        System.out.println("\nreduce:");
        String reduce = map.reduce(1,
                (key, value) -> {
                    System.out.println("Transform: " + Thread.currentThread().getName());
                    return key + "=" + value;
                },
                (s1, s2) -> {
                    System.out.println("Reduce: " + Thread.currentThread().getName());
                    return s1 + ", " + s2;
                });
        System.out.println(reduce);


    }
}