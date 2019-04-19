package com.company.interviewQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author dkorolev
 *         Date: 3/12/2019
 *         Time: 9:13 PM
 */
public class RemoveArrayDuplicatesMain <E> {

    public static void main(String[] args) {
        Integer[] ints = IntStream.of(1, 3, 5, 4, 3, 4, 5, 6, 2).boxed().toArray(Integer[]::new);
        Arrays.sort(ints);
        RemoveArrayDuplicatesMain<Integer> arrayDuplicatesMain = new RemoveArrayDuplicatesMain<>();
        arrayDuplicatesMain.printArray(ints);
        Integer[] removeDuplicates = arrayDuplicatesMain.removeDuplicates(Integer.class,ints);
        arrayDuplicatesMain.printArray(removeDuplicates);
    }


    public E[] removeDuplicates(Class<E> c, E[] array) {
        @SuppressWarnings("unchecked")
        E[] es = (E[]) Array.newInstance(c,array.length);
        int j = 0;
        es[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i-1]) {
                j++;
                es[j] = array[i];
            }
        }
        return es;
    }


    public void printArray(E[] array) {
        System.out.println("Array:");
        for (E e : array) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
}