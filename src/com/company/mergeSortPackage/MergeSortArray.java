package com.company.mergeSortPackage;

/**
 * @author dkorolev
 *         Date: 2/25/2019
 *         Time: 4:55 PM
 */
public class MergeSortArray {

    public void sort(int[] arr, int low, int high) {

        if (low<high) {

            int middle = (high + low) / 2;

            sort(arr, low, middle);
            sort(arr, middle+1, high);

            merge(arr, low, middle, high);
        }

    }

    private void merge(int[] arr, int low, int middle, int high) {

        //temp left and right arrays
        int leftSize = middle - low + 1;
        int rightSize = high - middle;
        int[] tempLeft = new int[leftSize];
        int[] tempRight = new int[rightSize];

        //filling them
        for (int i = 0; i < leftSize; i++) {
            tempLeft[i] = arr[low + i];
        }
        for (int i = 0; i < rightSize; i++) {
            tempRight[i] = arr[middle + 1 + i];
        }


        //merging in original array
        int i = 0;
        int j = 0;
        int k = low;
        while (i < leftSize && j < rightSize) {
            if (tempLeft[i] > tempRight[j]) {
                arr[k] = tempRight[j];
                j++;
            } else {
                arr[k] = tempLeft[i];
                i++;
            }
            k++;
        }

        //filling what left from left array
        if (i == leftSize) {
            for (int l = j; l < rightSize; l++) {
                arr[k] = tempRight[l];
                k++;
            }
        }
        //filling what left from right array
        if (j == rightSize) {
            for (int m = i; m < leftSize; m++) {
                arr[k] = tempLeft[m];
                k++;
            }
        }

    }

}