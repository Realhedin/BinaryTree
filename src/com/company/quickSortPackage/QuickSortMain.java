package com.company.quickSortPackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author dkorolev
 *         Date: 2/21/2019
 *         Time: 5:38 PM
 */
public class QuickSortMain {

    private final static int NUMBER = 255;

    public static void main(String[] args) {
//        int num[] = {2, 14, 9, 10, 1, 3, 12, 13, 5, 11, 6, 8, 15, 7, 4};
        int num[] = new int[NUMBER];
        Random random = new Random();
        for (int i = 0; i < NUMBER; i++) {
            num[i] = random.nextInt();
        }
//        Arrays.stream(num).forEach(a -> System.out.print(a +" "));
        System.out.println();
        QuickSort quickSort = new QuickSort();
        long start = System.nanoTime();
        quickSort.sort(num);
        long diff = System.nanoTime() - start;
        System.out.println(diff);
//        Arrays.stream(num).forEach(a -> System.out.print(a +" "));


//        int num2[] = {2, 14, 9, 10, 1, 3, 12, 13, 5, 11, 6, 8, 15, 7, 4};
        int num2[] = new int[NUMBER];
        for (int i = 0; i < NUMBER; i++) {
            num2[i] = random.nextInt();
        }
        System.out.println("\n");
        long start2 = System.nanoTime();
        Arrays.sort(num2);
        long diff2 = System.nanoTime() - start2;
        System.out.println(diff2);
        System.out.println();





        //For List<Integer>
        List<Integer> listOfInts = IntStream.range(1, 99).boxed().collect(Collectors.toList());
        Collections.shuffle(listOfInts);
        System.out.println(listOfInts);
        QuickSortList quickSortList = new QuickSortList();
        quickSortList.sort(listOfInts);
        System.out.println(listOfInts);


    }
}