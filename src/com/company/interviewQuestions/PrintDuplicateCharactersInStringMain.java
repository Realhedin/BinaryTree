package com.company.interviewQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dkorolev
 *         Date: 3/13/2019
 *         Time: 9:13 PM
 */
public class PrintDuplicateCharactersInStringMain {

    public static void main(String[] args) {
        String str = "chubakabra";
        printDuplicates(str);
    }


    public static void printDuplicates(String string) {
        char[] chars = string.toCharArray();

        Map<Character, Integer> mapWithDuplicates = new HashMap<>();

        //adding to map
        for (char a : chars) {
            if (mapWithDuplicates.containsKey(a)) {
                mapWithDuplicates.put(a, mapWithDuplicates.get(a) + 1);
            } else {
                mapWithDuplicates.put(a, 1);
            }
        }

        //print duplicates
        for (Map.Entry<Character, Integer> characterIntegerEntry : mapWithDuplicates.entrySet()) {
            if (characterIntegerEntry.getValue() > 1) {
                System.out.printf("character: %c found %d times\n",characterIntegerEntry.getKey(), characterIntegerEntry.getValue());
            }
        }

    }
}