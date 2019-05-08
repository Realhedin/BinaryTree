package com.company.rxJava.habr;


import rx.Subscription;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

/**
 * @author dkorolev
 *         Date: 5/6/2019
 *         Time: 2:40 PM
 */
public class Part3Main {

    public static void main(String[] args) {

        Subject<Integer,Integer> replaySubject = ReplaySubject.create();
        Subscription disposable = replaySubject.subscribe(
                v -> System.out.println("First: " +v),
                e -> System.err.println(e)
        );
        Subscription disposable2 = replaySubject.subscribe(
                v -> System.out.println("Second: " + v),
                e -> System.err.println(e),
                () -> System.out.println("Done")
        );

        replaySubject.onNext(0);
        replaySubject.onNext(1);
//        replaySubject.onError(new RuntimeException("Some exception."));

        //unsubscribe 1st subscriber
        disposable.unsubscribe();
        System.out.println("First unsubscribed");
        replaySubject.onNext(2);

        //set to complete, so sequence is closed
        replaySubject.onCompleted();
        replaySubject.onNext(3);



    }
}