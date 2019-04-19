package com.company.mergeSortPackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author dkorolev
 *         Date: 2/25/2019
 *         Time: 5:44 PM
 */
public class MergeSortMain {

    public static void main(String[] args) {

        int[] array = {3,2,6,4,7,1,5};
        Arrays.stream(array).forEach(System.out::print);

        MergeSortArray mergeSortArray = new MergeSortArray();
        mergeSortArray.sort(array,0,array.length-1);

        System.out.println("\n");
        Arrays.stream(array).forEach(System.out::print);

        System.out.println("\n");
        List<Integer> collect = IntStream.range(1, 9).boxed().collect(Collectors.toList());
        Collections.shuffle(collect);
        collect.stream().forEach(System.out::print);
        MergeSortList mergeSortList = new MergeSortList();
        mergeSortList.sortList(collect,0,collect.size()-1);
        System.out.println();
        collect.stream().forEach(System.out::print);
    }
}