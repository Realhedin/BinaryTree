package com.company.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dkorolev on 4/20/2019.
 */
public class StreamsCreation {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a", "b", "c");
        int[] arr = new int[]{1, 2, 3};
        char[] chars = new char[]{'a', 'b', 'c'};
        String[] strings = new String[]{"a", "b", "c"};
        String string = "string";

        //from collection
        Stream<String> fromCollection =  stringList.stream();
        fromCollection.forEach((a) -> System.out.print(a+" "));
        System.out.println();

        //from elements
        Stream<String> fromElements =  Stream.of("a","b","c");
        fromElements.forEach((a) -> System.out.print(a+" "));
        System.out.println();

        //from Array
        IntStream stream = Arrays.stream(arr);
        stream.forEach((a) -> System.out.print(a+" "));
        System.out.println();
        Stream<String> stream1 = Arrays.stream(strings);
        stream1.forEach((a) -> System.out.print(a+" "));
        System.out.println();

        //from String
        IntStream fromString = string.chars();
        fromString.forEach((a) -> System.out.print(a+" "));
        System.out.println();

        //infinite stream
        Stream<Integer> infiniteStream = Stream.iterate(1, n -> n + 1);
        infiniteStream.limit(10).forEach((a) -> System.out.print(a+" "));
        System.out.println();
    }
}
