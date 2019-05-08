package com.company.rxJava.habr.part2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;


/**
 * @author dkorolev
 *         Date: 5/7/2019
 *         Time: 4:25 PM
 */
public class SequenceCreation2 {
    public static void main(String[] args) {

        //Observable.range
        Observable<Integer> range = Observable.range(10, 15);
        range.subscribe(System.out::println);
        System.out.println();

        //Observable.interval
//        Observable<Long> interval = Observable.interval(1000, TimeUnit.MICROSECONDS);
//        interval.subscribe(
//                v -> System.out.println("Received: " +v),
//                e -> System.err.println("Error: " + e),
//                () -> System.out.println("Completed")
//        );
//        try {
//            //Mandatory, because subscribe is non-blocking Main from finishing!
//            System.in.read();
//        } catch (IOException e) {
//
//        }


        //Observable.timer
        //1st
//        Observable<Long> timer = Observable.timer(1, TimeUnit.SECONDS);
//        Disposable completed = timer.subscribe(
//                v -> System.out.println("Received: " + v),
//                e -> System.err.println("Error: " + e),
//                () -> System.out.println("Completed")
//        );
//        try {
//            //Mandatory, because subscribe is non-blocking Main from finishing!
//            System.in.read();
//        } catch (IOException e) {
//
//        }

        //2nd
        Observable<Long> values = Observable.timer(2, TimeUnit.SECONDS, Schedulers.computation());
        Subscription subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
        );
        try {
            //Mandatory, because subscribe is non-blocking Main from finishing!
            System.in.read();
        } catch (IOException e) {

        }


    }
}