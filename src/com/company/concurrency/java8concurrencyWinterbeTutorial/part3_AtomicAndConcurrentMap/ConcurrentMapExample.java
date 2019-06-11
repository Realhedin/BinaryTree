package com.company.concurrency.java8concurrencyWinterbeTutorial.part3_AtomicAndConcurrentMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author dkorolev
 *         Date: 6/10/2019
 *         Time: 4:08 PM
 */
public class ConcurrentMapExample {
    public static void main(String[] args) {

        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.forEach((key,value) -> System.out.printf("%s = %s\n",key, value));

        String value = map.putIfAbsent("c3", "p1");
        System.out.println(value);

        String value2 = map.getOrDefault("hi", "there");
        System.out.println(value2);

        map.replaceAll((key, v) -> "r2".equals(key) ? "d3" : v);
        System.out.println(map.get("r2"));

        map.compute("foo", (k, v) -> v + v);
        System.out.println(map.get("foo"));

        map.computeIfAbsent("h1", v -> "test" );
        System.out.println(map.get("h1"));

        map.computeIfPresent("h1", (k,v) -> "test333" );
        System.out.println(map.get("h1"));
    }
}