package com.company.interviewQuestions;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author dkorolev
 *         Date: 3/13/2019
 *         Time: 10:25 PM
 */
public class ReverseWordsInStringMain {

    public static void main(String[] args) {
        String sentence = "I am going home";
        System.out.println(sentence);
//        String s = reverseWords(sentence);
        String s = reverseString(sentence);
        System.out.println(s);
    }


    public static String reverseWords(String string) {
        String[] split = string.split("\\s+");
        Arrays.sort(split,Collections.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
           stringBuilder.append(s).append(" ");
        }
        return stringBuilder.toString();
    }


    public static String reverseString(String string) {
        String[] split = string.trim().split("\\s");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length-1; i >=0; i--) {
            stringBuilder.append(split[i]).append(" ");
        }
        return stringBuilder.toString();
    }
}