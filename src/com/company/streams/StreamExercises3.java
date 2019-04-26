package com.company.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dkorolev
 *         Date: 4/22/2019
 *         Time: 2:20 PM
 */
public class StreamExercises3 {

    public static void main(String[] args) {
        Collection<String> ordered = Arrays.asList("a1", "a2",  "a3", "a1");

        boolean a1Exists = ordered.stream().anyMatch("a1"::equals);

        boolean contains1 = ordered.stream().allMatch(s->s.contains("1"));

        boolean nonea7exists = ordered.stream().noneMatch("a7"::equals);



        //------------------------------
        List<String> collection1 = Arrays.asList("a1", "a2", "a3", "a1");
        List<String> collection2 = Arrays.asList("1,2,0", "4,5");

        List<String> containing_1 = collection1.stream().map(s->s+"_1").collect(Collectors.toList());
        containing_1.forEach(System.out::print);
        System.out.println();

        List<String> listWithout1value = collection1.stream().map(s->s.substring(1,s.length())).collect(Collectors.toList());
        listWithout1value.forEach(System.out::print);
        System.out.println();
        int[] ints = collection1.stream().mapToInt(s -> Integer.parseInt(s.substring(1))).toArray();
        Arrays.stream(ints).forEach(System.out::print);
        System.out.println();

        Object[] objects = collection2.stream().flatMap(s -> Arrays.asList(s.split(",")).stream()).toArray(String[]::new);
        Arrays.stream(objects).forEach((s) -> System.out.print(s+" "));
        System.out.println();

        int sum = collection2.stream().flatMap(s -> Arrays.asList(s.split(",")).stream()).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
    }
}