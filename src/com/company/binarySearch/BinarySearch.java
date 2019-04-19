package com.company.binarySearch;

import java.util.Arrays;

/**
 * @author dkorolev
 *         Date: 2/27/2019
 *         Time: 5:25 PM
 */
public class BinarySearch {


    public void binarySortRecursive(int[] arr, int key) {
        int position = arr.length / 2;
        int middle = arr[position];

        if (key == middle) {
            System.out.println("Key was found");
        } else {
            if (key > middle) {
                binarySortRecursive(Arrays.copyOfRange(arr, position, arr.length), key);
            } else {
               binarySortRecursive(Arrays.copyOfRange(arr, 0, position), key);
            }
        }
    }

    public void binarySortRecursiveImpr(int[] arr, int key, int high, int low) {
        int position = (high+low) / 2;
        int middle = arr[position];

        if (key == middle) {
            System.out.println("Key was found");
        } else {
            if (key > middle) {
                low = position;
                binarySortRecursiveImpr(arr, key, high, low);
            } else {
                high = position + 1;
                binarySortRecursiveImpr(arr, key, high, low);
            }
        }
    }


    public void binarySortIterative(int[] arr, int key) {
        while (arr.length > 1) {
            int position = arr.length / 2;
            int middle = arr[position];

            if (key == middle) {
                System.out.println("Key was found");
                return;
            } else {
                if (key > middle) {
                    arr = Arrays.copyOfRange(arr, position, arr.length);
                } else {
                    arr = Arrays.copyOfRange(arr, 0, position);
                }
            }
        }

        if (key == arr[0]) {
            System.out.println("Key was found");
        } else {
            System.out.println("Key was not found");
        }
    }


    public void binarySortIterativeImpr(int[] arr, int key) {
        int low = 0;
        int high = arr.length -1;

        while (low < high) {
            int position = (high + low) / 2;
            int middle = arr[position];

            if (key == middle) {
                System.out.println("Key was found");
                return;
            } else {
                if (key > middle) {
                    low = position;
                } else {
                    high = position + 1;
                }
            }
        }
    }


}