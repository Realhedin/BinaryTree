package com.company.rxJava.habr.part2;


import rx.Observable;
import rx.Subscription;

/**
 * @author dkorolev
 *         Date: 5/7/2019
 *         Time: 12:18 PM
 */
public class SequenceCreation {

    public static void main(String[] args) {

         //Observable.just
        Observable<String> values = Observable.just("one", "two", "three");
        Subscription subscription = values.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.err.println("Error: " + e),
                () -> System.out.println("Completed")
        );
        System.out.println();


        //Observable.defer (Calculated  each time for new subscription)
        Observable<Long> currentTimeDefer
                = Observable.defer(() -> Observable.just(System.currentTimeMillis()));
        currentTimeDefer.subscribe(System.out::println);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        currentTimeDefer.subscribe(System.out::println);
        System.out.println();


        //Observable.create
        Observable<Object> createObservable = Observable.create(
                o -> {
                    o.onNext("Hello");
                    o.onCompleted();
                }
        );
        Subscription subscribeCreate = createObservable.subscribe(
                v -> System.out.println("Received: " + v),
                e -> System.err.println("Error: " + e),
                () -> System.out.println("Completed")
        );

    }
}