package com.company.interviewQuestions;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author dkorolev
 *         Date: 3/12/2019
 *         Time: 9:18 PM
 */
public class RemoveDuplicatesFromListMain <E> {

    public static void main(String[] args) {
        List<Integer> intList = IntStream.of(1, 2, 5, 2, 4, 1, 5, 6).boxed().collect(Collectors.toList());
        System.out.println(intList);
        RemoveDuplicatesFromListMain<Integer> duplicatesFromListMain = new RemoveDuplicatesFromListMain<>();
        List<Integer> removeDuplicates = duplicatesFromListMain.removeDuplicates(intList);
        System.out.println(removeDuplicates);
    }


    public List<E> removeDuplicates(List<E> input) {
        Set<E> hashSet = new LinkedHashSet<>(input);
        input.clear();
        input.addAll(hashSet);
        return input;
    }
}