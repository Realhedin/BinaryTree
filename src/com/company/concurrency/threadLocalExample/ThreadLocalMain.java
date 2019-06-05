package com.company.concurrency.threadLocalExample;

/**
 * @author dkorolev
 *         Date: 5/29/2019
 *         Time: 3:49 PM
 */
public class ThreadLocalMain {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " started");

        MyRunnable myRunnable = new MyRunnable();

        new Thread(myRunnable, "Thread 1") .start();
        new Thread(myRunnable, "Thread 2") .start();

    }





    static class MyRunnable implements Runnable {

        ThreadLocal<Integer> localVar = new ThreadLocal<>();
//        Integer var;

        @Override
        public void run() {
             localVar.set((int) (Math.random() * 1000));
//            var = ((int) (Math.random() * 1000));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println(localVar + Thread.currentThread().getName());
        }
    }
}