package com.company.concurrency.java8concurrencyWinterbeTutorial.part1;

/**
 * @author dkorolev
 *         Date: 5/30/2019
 *         Time: 5:36 PM
 */
public class HelloExample {

    public static void main(String[] args) {

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Hello " + name);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println(Thread.currentThread().getName() +" done");

    }
}