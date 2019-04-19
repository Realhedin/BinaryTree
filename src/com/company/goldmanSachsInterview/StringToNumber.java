package com.company.goldmanSachsInterview;

/**
 * @author dkorolev
 *         Date: 4/18/2019
 *         Time: 7:21 PM
 */
public class StringToNumber {

    public static Long stringToNumber(String s) {
        try{
            if (s == null) {
                return 0L;
            }
            if (s.length() > 64) {
                System.err.println("Size of String is too big");
                return Long.MIN_VALUE;
            }
            if (s.length() == 0) {
                return 0L;
            }
            return Long.valueOf(s);
        } catch (NumberFormatException e) {
            System.err.println("String cannot become Integer");
            return Long.MIN_VALUE;
        }
    }
}