package com.company.leetCode;

/**
 * @author dkorolev
 *         Date: 4/10/2019
 *         Time: 7:09 PM
 */
public class RevertIntegerMain {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

    static int reverse(int x) {
        long reversedX = 0;
        int sign = 1;
        if (x<0) {
            sign = -1;
        }
        x = Math.abs(x);
        while (x>0) {
            int temp = x%10;
            reversedX = temp + reversedX*10;
            x = x/10;
            if (reversedX>Integer.MAX_VALUE) {
                return 0;
            }

        }
        return (int)reversedX*sign;
    }
}