package com.company.interviewQuestions;

/**
 * @author dkorolev
 *         Date: 3/12/2019
 *         Time: 8:39 PM
 */
public class IntegerPalindromeMain {

    public static void main(String[] args) {
        int value = 12321;
        boolean b = checkPalindrome(value);
        System.out.println("is number a palindrome?" + b);
    }

    public static boolean checkPalindrome(int number) {
        int palindrome = number;
        int revPalindrome = 0;
        int reminder;

        while (number != 0) {
            reminder = number % 10;
            revPalindrome = revPalindrome*10 + reminder;
            number = number / 10;
        }

        return palindrome == revPalindrome;
    }
}