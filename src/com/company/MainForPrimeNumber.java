package com.company;

/**
 * @author dkorolev
 *         Date: 2/19/2019
 *         Time: 4:36 PM
 */
public class MainForPrimeNumber {
    public static void main(String[] args) {

        //2. Prime numbers
        //check from 2 up to sqrt(number)
        checkPrime(33333331);

    }


    public static boolean checkPrime(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            System.out.println(2);
            return false;
        }
        for (int i = 3; i < Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                System.out.println(i);
                return false;
            }
        }
        System.out.println(number + " is a prime number");
        return true;
    }
}