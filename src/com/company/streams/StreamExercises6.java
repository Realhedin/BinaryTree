package com.company.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author dkorolev
 *         Date: 4/23/2019
 *         Time: 2:25 PM
 */
public class StreamExercises6 {
    public static void main(String[] args) {

        Collection<Integer> ordered = Arrays.asList(1,2,3,4);

        List<String> strings = Arrays.asList("aaa", "bbb", "ccc", "ddd", "ffff");

        //calculate sum
        Integer sum = ordered.stream().reduce((n1,n2) -> n1 + n2).get();
        System.out.println(sum);

        Integer max = ordered.stream().max(Integer::compareTo).orElse(-1);
        Integer integer = ordered.stream().reduce((n1, n2) -> n1 > n2 ? n1 : n2).orElse(-1);
        System.out.println(max);
        System.out.println(integer);

        Integer oddSum = ordered.stream().filter(n -> n%2!=0).reduce(0,(n1,n2)-> n1 +n2);
        System.out.println(oddSum);

        String longestString = strings.stream().reduce("", (s1, s2) -> s1.length() > s2.length() ? s1 : s2);
        System.out.println(longestString);

        //calculate sum from 10
        Integer reduceSumFrom10 = ordered.stream().reduce(10, (n1, n2) -> n1 + n2);
        System.out.println(reduceSumFrom10);

        //10 - identity, identity*val = accumulator, summing - combiner
        //Only with parallelStreams!
        Integer complexReduce = ordered.parallelStream().reduce(10, (identity, val) -> identity * val, (n1, n2) -> n1 + n2);
        System.out.println(complexReduce);



    }
}