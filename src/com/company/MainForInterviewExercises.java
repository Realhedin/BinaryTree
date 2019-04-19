package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dkorolev
 *         Date: 2/18/2019
 *         Time: 6:29 PM
 */
public class MainForInterviewExercises {

    public static void main(String[] args) {

        HashMap<Integer, Integer> cache = new HashMap<>();

        //Write a Java program to replace certain characters from String like
        replace("test", 't');

        //1. Fibonacci series
        fibbonacchi(13);
        System.out.println();
        long start = System.nanoTime();
//        for (int i = 1; i < 1000000; i++) {
//            System.out.print(fibbonacchiRec(i) + " ");
        System.out.println(fibbonacchiRec(40));
        System.out.println(fibbonacchiRec(40));
//        }
        long diffTime = System.nanoTime() - start;
        System.out.println("Reccursion:" + diffTime);
        System.out.println();
        start = System.nanoTime();
//        for (int i = 1; i < 1000000; i++) {
//            System.out.print(fibbonacchiRecImpr(i,cache) + " ");
        System.out.println(fibbonacchiRecImpr(40,cache));
        System.out.println(fibbonacchiRecImpr(40,cache));
//        }
        diffTime = System.nanoTime() - start;
        System.out.println("ReccursionImpr:" + diffTime);


    }


    //Write a Java program to replace certain characters from String like
    public static String replace(String str, char ch) {
        System.out.println(str);
        String replace = str.replace(ch, 'p');
        System.out.println(replace);
        return replace;
    }

    //1. Fibonacci series
    public static void fibbonacchi(int num) {
        int i = 1;
        int j = 0;
        int temp;
        System.out.print(i + " ");
        while (i <= num) {
            System.out.print(i+j + " ");
            temp = i;
            i +=j;
            j = temp;
        }
    }

    //1. Fibonacci series (recursion)
    public static int fibbonacchiRec(int number) {
        if(number == 1 || number == 2)
        {
            return 1;
        }
        return fibbonacchiRec(number-1) + fibbonacchiRec(number -2); //tail recursion
    }


    //1. Fibonacci series improved (recursion)
    public static int fibbonacchiRecImpr(int number, Map<Integer, Integer> cache) {
        Integer fibonacchi = cache.get(number);
        if (fibonacchi != null) {
            return fibonacchi;
        }
        fibonacchi = fibbonacchiRec(number);
        cache.put(number, fibonacchi);
        return fibonacchi;

    }


}