package com.company.goldmanSachsInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author dkorolev
 *         Date: 4/18/2019
 *         Time: 7:21 PM
 */
public class CombineTwoArraysIntoOne <T> {


    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        Integer[] b = {4, 5, 6};
        Object[] objects = concatenateJava8(a, b);
        System.out.println(objects);
        Object[] objects2 = concatenateJava8_2(a, b);
        System.out.println(objects2);
        Object[] objects3 = concantenate(a, b);
        System.out.println(objects3);
    }

     public static Object[] concantenate(Integer[] a, Integer[] b) {
         List<Integer> list = new ArrayList<>();

         Collections.addAll(list,a);
         Collections.addAll(list,b);

         return list.toArray();
     }


    public static <T>Object[] concatenateJava8(T[] a, T[] b) {
        return Stream.of(a,b)
                .flatMap(Stream::of)
                .toArray();
    }


    public static <T> Object[] concatenateJava8_2(T[] a, T[] b) {
        if (a == null && b == null) {
            return new Object[0];
        }
        if (a == null) {
            System.err.println("");
            return b;
        }
        if (b == null) {
            System.err.println("");
            return a;
        }
        return Stream.concat(Arrays.stream(a), Arrays.stream(b))
                .toArray();
    }
}