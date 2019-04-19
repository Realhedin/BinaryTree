package com.company.concurrency;

/**
 * @author dkorolev
 *         Date: 2/27/2019
 *         Time: 4:56 PM
 */
public class DeadLock {

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (Integer.class) {
                System.out.println(Thread.currentThread().getName() + " has a lock on Integer");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                synchronized (String.class) {
                    System.out.println(Thread.currentThread().getName() + " has a lock on String");
                }
            }
        }).start();


        new Thread(() -> {
            synchronized (String.class) {
                System.out.println(Thread.currentThread().getName() + " has a lock on String");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                synchronized (Integer.class) {
                    System.out.println(Thread.currentThread().getName() + " has a lock on Integer");
                }
            }
        }).start();
    }
}