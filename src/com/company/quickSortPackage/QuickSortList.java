package com.company.quickSortPackage;

import java.util.List;

/**
 * @author dkorolev
 *         Date: 2/22/2019
 *         Time: 3:50 PM
 */
public class QuickSortList {

    List<Integer> someList;


    public void sort(List<Integer> list) {
        someList = list;
        quickSort(0, list.size()-1);
    }


    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        Integer pivot = someList.get(low + (high - low) / 2);

        while (i <= j) {

            //iterate from left
            while (someList.get(i) < pivot) {
                i++;
            }
            //iterate from right
            while (pivot < someList.get(j)) {
                j--;
            }

            //swap if needed
            if (i <= j) {
                swap(i,j);
                i++;
                j--;
            }
        }

            //recursive next call
            if (low < j) {
                quickSort(low,j);
            }
            if (i < high) {
                quickSort(i,high);
            }





    }

    private void swap(int i, int j) {
        Integer integer = someList.get(i);
        someList.set(i,someList.get(j));
        someList.set(j,integer);
    }

}