package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B,C and D of int values.
 * Compute how many tuples (i, j, k, l) there so it's sum is 0.
 * For example, A[0] + B[1] + C[1] + D[0] == 0.
 */
public class FourSumCount {
    public int fourSumCountMethod(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> sums = new HashMap<>();
        int counter = 0;

        //make all sums of A and B
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                sums.put(sum, sums.getOrDefault(sum, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> keyValue : sums.entrySet()) {
            System.out.println("Key: " + keyValue.getKey() + "Value " + keyValue.getValue());
        }

        //and compare with all sums of C and D with value inversion
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = -(C[i] + D[j]);
                //if sum exists, then return number of existing and increase counter
                if (sums.containsKey(sum)) {
                    counter += sums.get(sum);
                }
            }
        }

        return counter;
    }
}
