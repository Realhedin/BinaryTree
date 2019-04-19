package com.company.mergeSortPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkorolev
 *         Date: 2/26/2019
 *         Time: 6:49 PM
 */
public class MergeSortList {

    public void sortList(List<Integer> list, int low, int high) {

        if (low < high) {
            int medium = (high + low) / 2;

            sortList(list, low, medium);
            sortList(list, medium+1, high);

            mergeList(list, low, high, medium);
        }
    }

    private void mergeList(List<Integer> list, int low, int high, int medium) {

        //create temp lists helpers
        List<Integer> leftList = new ArrayList<>(medium - low + 1);
        List<Integer> rightList = new ArrayList<>(high - medium);

        //fill temp lists helpers with values from original
        int leftBorder = medium - low + 1;
        for (int i = 0; i < leftBorder; i++) {
            leftList.add(i,list.get(low+i));
        }

        int rightBorder = high - medium;
        for (int i = 0; i < rightBorder; i++) {
            rightList.add(i,list.get(medium+i+1));
        }


        int i = 0;
        int j = 0;
        int k = low;


        while (i < leftBorder && j < rightBorder) {
            if (leftList.get(i) < rightList.get(j)) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        //check which border do we achieved
        if (i == leftBorder) {
            while (j < rightBorder) {
                list.set(k, rightList.get(j));
                j++;
                k++;
            }
        }
        if (j == rightBorder) {
            while (i < leftBorder) {
                list.set(k, leftList.get(i));
                i++;
                k++;
            }
        }


    }
}