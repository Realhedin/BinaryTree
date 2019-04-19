package com.company.binarySearch;

import java.util.stream.IntStream;

/**
 * @author dkorolev
 *         Date: 2/27/2019
 *         Time: 5:32 PM
 */
public class BinarySearchMain {

    public static void main(String[] args) {

        int[] arraySorted = IntStream.range(1, 12).toArray();

        BinarySearch binarySearch = new BinarySearch();
//        binarySearch.binarySortIterative(arraySorted, 6);


//        binarySearch.binarySortIterativeImpr(arraySorted, 3);
        binarySearch.binarySortRecursiveImpr(arraySorted,3, arraySorted.length-1, 0);



    }
}