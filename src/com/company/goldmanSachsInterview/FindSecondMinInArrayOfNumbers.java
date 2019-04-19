package com.company.goldmanSachsInterview;

/**
 * @author dkorolev
 *         Date: 4/16/2019
 *         Time: 10:53 AM
 */
public class FindSecondMinInArrayOfNumbers {

    //O(n)
    public static int findSecondMin_basic(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int i : arr) {
            if (i < min) {
                secMin = min;
                min = i;
            }
            if (i>min&&i<secMin) {
                secMin = i;
            }
        }
        if (secMin == Integer.MAX_VALUE) {
            throw new RuntimeException();
        }
        return secMin;
    }
}