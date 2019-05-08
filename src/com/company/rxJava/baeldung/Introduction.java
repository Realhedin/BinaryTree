package com.company.rxJava.baeldung;

import java.util.Arrays;
import java.util.List;

import rx.Observable;


/**
 * @author dkorolev
 *         Date: 5/8/2019
 *         Time: 4:11 PM
 */
public class Introduction {
    private static String[] titles = {"title"};
    private static List<String> titleList = Arrays.asList(titles);

    public static void main(String[] args) {


        //Observable.just
        Observable<String> hello = Observable.just("Hello");
        hello.subscribe(System.out::println);
        System.out.println();

        //onNext, onError, onCompleted
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        Observable<String> observable = Observable.from(letters);
        observable.subscribe(
                i -> System.out.print(i), //onNext
                Throwable::printStackTrace, //OnError
                () -> System.out.print("_Completed") //OnCompleted
        ) ;
        System.out.println("\n");


        //map
        System.out.println("Map:");
        Observable.from(letters)
                .map(String::toUpperCase)
                .subscribe(System.out::print);
        System.out.println("\n");

        //flatMap
        System.out.println("FlatMap:");
        Observable.just("book1","book2")
                .flatMap(s -> getTitle())
                .subscribe(System.out::print);
        System.out.println();


        //scan
        String[] letters2 = {"a", "b", "c"};
        Observable.from(letters2)
                .scan(new StringBuilder(), StringBuilder::append)
                .subscribe(System.out::println);




    }

    static Observable<String> getTitle() {
        return Observable.from(titleList);
    }



}