package com.company.interviewQuestions;

/**
 * @author dkorolev
 *         Date: 3/12/2019
 *         Time: 8:57 PM
 */
public class FactorialMain {
    public static void main(String[] args) {
        int factorialNumber = factorialIter(15);
        System.out.println(factorialNumber);
    }


    public static int factorialRec(int number) {
        if (number == 1) {
            return 1;
        }
        return number * factorialRec(number - 1);
    }


    public static int factorialIter(int number) {
        int fact = 1;
        for (int i = 2; i < number; i++) {
                 fact *= i;
        }
        return fact;
    }
}