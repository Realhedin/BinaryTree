package com.company.stringInvertion;

/**
 * @author dkorolev
 *         Date: 3/4/2019
 *         Time: 7:07 PM
 */
public class InvertStringWithWhitespaces {

    public String invertStringWithWhitespaces(String string) {
        char[] input = string.toCharArray();
        char[] result = new char[string.length()];

        //mark in result all whitespaces
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == ' ') {
                result[i] = ' ';
            }
        }

        int j = input.length-1;

        //reverse string without whitespaces
        for (int i = 0; i < string.length(); i++) {
            if (input[i] != ' ') {
                //if whitespace existed, we decrease counter
                if (result[j] == ' ') {
                    j--;
                }
                //else add in reverse order
                result[j] = input[i];
                j--;
            }
        }

        return String.valueOf(result);

    }
}