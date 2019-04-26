package com.company.rxJava;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * @author dkorolev
 *         Date: 4/26/2019
 *         Time: 3:28 PM
 */
public class SubjectMain {
    public static void main(String[] args) throws InterruptedException {

        //implementation of Subject which extend Observable and implement Observer
        //subscriber will get messages which happens after subscription
        PublishSubject<Integer> publishSubject = PublishSubject.create();
        publishSubject.onNext(1);
        publishSubject.subscribe(System.out::println);
        publishSubject.onNext(2);
        publishSubject.onNext(3);
        publishSubject.onNext(4);
        System.out.println();

        //can cache input data
        //even late subscriber will get all messages from the beginning
        ReplaySubject<Integer> replaySubject = ReplaySubject.create();
        replaySubject.subscribe(v-> System.out.println("Early: "+ v));
        replaySubject.onNext(0);
        replaySubject.onNext(1);
        replaySubject.subscribe(v-> System.out.println("Late: "+ v));
        replaySubject.onNext(2);
        System.out.println();

        //restriction to 2 values
        ReplaySubject<Integer> s = ReplaySubject.createWithSize(2);
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.subscribe(v -> System.out.println("Late: " + v));
        s.onNext(3);
        System.out.println();

        ReplaySubject<Integer> replaySubject1 = ReplaySubject.createWithTime(150, TimeUnit.MILLISECONDS, Schedulers.computation());
        replaySubject1.onNext(0);
        Thread.sleep(100);
        replaySubject1.onNext(1);
        Thread.sleep(100);
        replaySubject1.onNext(2);
        replaySubject1.subscribe(v -> System.out.println("Late: " + v));
        replaySubject1.onNext(3);
        System.out.println();


        //behavior subject
        //have only latest value
        BehaviorSubject<Integer> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.onNext(0);
        behaviorSubject.onNext(1);
        behaviorSubject.onNext(2);
        behaviorSubject.subscribe(v -> System.out.println("Late: " + v));
        behaviorSubject.onNext(3);
        System.out.println();


        //async subject - save last value
        //give value only at the end
        AsyncSubject<Integer> asyncSubject = AsyncSubject.create();
        asyncSubject.subscribe(System.out::println);
        asyncSubject.onNext(0);
        asyncSubject.onNext(1);
        asyncSubject.onNext(2);
        asyncSubject.onComplete();;
    }
}