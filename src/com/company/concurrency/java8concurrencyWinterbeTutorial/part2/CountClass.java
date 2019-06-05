package com.company.concurrency.java8concurrencyWinterbeTutorial.part2;

/**
 * @author dkorolev
 *         Date: 6/4/2019
 *         Time: 3:43 PM
 */
public class CountClass {

    private  int count = 0;

    public  void increment() {
        count += 1;
    }

    public  synchronized void syncIncrement() {
        count += 1;
    }



    public  int getCount() {
        return count;
    }
}