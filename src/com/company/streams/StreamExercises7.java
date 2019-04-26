package com.company.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dkorolev
 *         Date: 4/24/2019
 *         Time: 12:48 PM
 */
public class StreamExercises7 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<String> stringList = Arrays.asList("a1", "b2", "c3", "a1");


        Integer sumOdd1 = list.stream().filter(s->s%2!=0).reduce((s1,s2)->s1+s2).get();
        System.out.println(sumOdd1);
        Integer sumOdd2 = list.stream().collect(Collectors.summingInt(p->p%2!=0 ? p : 0));
        System.out.println(sumOdd2);

        double asDouble = list.stream().mapToInt(s -> s - 1).average().getAsDouble();
        System.out.println(asDouble);

        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(p -> p + 3));
        System.out.println(collect);

        Map<Boolean, List<Integer>> collect1 = list.stream().collect(Collectors.partitioningBy(p -> p % 2 != 0));
        System.out.println(collect1);


        //------
        List<String> distinct1 = stringList.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct1);

        String[] strUppers = stringList.stream().distinct().map(String::toUpperCase).toArray(String[]::new);
        Arrays.stream(strUppers).forEach(System.out::print);
        System.out.println();

        String collect2 = stringList.stream().collect(Collectors.joining(": ", "<b> ", " </b>"));
        System.out.println(collect2);

        Map<String, String> collect3 = stringList.stream().distinct()
                .collect(Collectors.toMap((s) -> s.substring(0,1), (s) -> s.substring(1, 2)));
        System.out.println(collect3);

        Map<String, List<String>> collect4 = stringList.stream().collect(Collectors.groupingBy(s -> s.substring(0, 1)));
        System.out.println(collect4);

        Map<String, String> collect6 = stringList.stream()
                .collect(Collectors.groupingBy((p) -> p.substring(0, 1), Collectors.mapping((p) -> p.substring(1, 2),
                        Collectors.joining(":"))));
        System.out.println(collect6);
    }
}