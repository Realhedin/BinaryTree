package com.company.interviewQuestions;

/**
 * @author dkorolev
 *         Date: 3/12/2019
 *         Time: 8:48 PM
 */
public class AmstrongNumberMain {


    public static void main(String[] args) {
        int value = 153;
        boolean b = checkAmstrongNumber(value);
        System.out.println("Is number amstrong?" + b);
    }


    public static boolean checkAmstrongNumber(int number) {
        int amstrongNumber = 0;
        int input = number;
        int remainder = 0;

        while (number != 0) {
            remainder = number % 10;
            amstrongNumber += (int) Math.pow(remainder, 3);
            number = number / 10;
        }

        return amstrongNumber == input;
    }
}