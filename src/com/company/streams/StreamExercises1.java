package com.company.streams;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dkorolev on 4/21/2019.
 */
public class StreamExercises1 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a1", "a2", "a3", "a1");


        //number of a1 entries
        long count = stringList.stream().filter("a1"::equals).count();
        System.out.println(count);

        //1st element of collection or 0
        String s = stringList.stream().findFirst().orElse("0");
        System.out.println(s);

        //find last element of collection
        String empty = stringList.stream().skip(stringList.size() - 1).findFirst().orElse("Empty");
        System.out.println(empty);

        //find Element a4, if not - throw exception
        String s1 = stringList.stream().filter("a3"::equals).findFirst().orElseThrow(NoSuchElementException::new);
        System.out.println(s1);

        //print 3rd element
        String empty1 = stringList.stream().skip(2).findFirst().orElse("Empty");
        System.out.println(empty1);

        //print 2 elements after 1st
        List<String> collect = stringList.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println(collect);

        //print elements containing "1"
        List<String> collect1 = stringList.stream().filter(s3 -> s3.contains("1")).collect(Collectors.toList());
        System.out.println(collect1);

    }
}
