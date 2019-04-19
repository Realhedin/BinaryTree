package com.company.quickSortPackage;

/**
 * @author dkorolev
 *         Date: 2/21/2019
 *         Time: 5:39 PM
 */
public class QuickSort {

    private int[] array;
    private int length;


    public void sort(int[] numbers) {
        array = numbers;
        length = numbers.length;
        quickSort(0,length-1);
    }

    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        int pivot = array[(low + ((high - low) / 2))];

        while (i <= j) {

            //iterate from left
            while (array[i] < pivot) {
                i++;
            }
            //iterate from right
            while (array[j] > pivot) {
                j--;
            }

            //change places in array
            if (i<=j) {
                swap(i,j);
                i++;
                j--;
            }
        }

        //recursion call in divided part
        if (low < j) {
            quickSort(low, j);
        }
        if (i < high) {
            quickSort(i, high);
        }

    }


    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}