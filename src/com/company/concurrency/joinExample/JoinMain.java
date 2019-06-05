package com.company.concurrency.joinExample;

import java.time.LocalDateTime;

/**
 * @author dkorolev
 *         Date: 5/24/2019
 *         Time: 5:20 PM
 */
public class JoinMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new JoinClass());
        thread.start();
        System.out.println("Thread "+ Thread.currentThread().getName() + " is started" + LocalDateTime.now());
        try {
            System.out.println("Called join. Thread "+ Thread.currentThread().getName() + LocalDateTime.now());
            thread.join();
        } catch (InterruptedException e) {

        }
        System.out.println("After join. Thread "+ Thread.currentThread().getName() + LocalDateTime.now());

    }


    static class JoinClass implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            System.out.println("JoinClass run() " + LocalDateTime.now() + "Thread: " + Thread.currentThread().getName());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            System.out.println("After sleep" + "Thread: " + Thread.currentThread().getName());
        }
    }
}