package com.company.interviewQuestions;

/**
 * @author dkorolev
 *         Date: 3/12/2019
 *         Time: 8:09 PM
 */
public class StringPalindromeMain {

    public static void main(String[] args) {
        String palindrome = "Bob";
        boolean b = checkPalindrome(palindrome);
        System.out.println("Is palindrome? " + b);
    }


    public static boolean checkPalindrome(String string) {
        char[] input = string.toLowerCase().toCharArray();
        int j = input.length-1;
        int i=0;

        while (i <= j) {
            if (input[i] != input[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}