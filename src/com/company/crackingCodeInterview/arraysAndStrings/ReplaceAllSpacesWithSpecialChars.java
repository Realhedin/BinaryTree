package com.company.crackingCodeInterview.arraysAndStrings;

import java.util.Objects;

/**
 * @author dkorolev
 *         Date: 4/25/2019
 *         Time: 2:54 PM
 */
public class ReplaceAllSpacesWithSpecialChars {


    public static void main(String[] args) {
        String str = "abc deg ada";
        System.out.println(changeWhitespaces(str));
    }



    public static String changeWhitespaces(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null || Objects.equals(str, "")) {
            return null;
        }
        for(int i =0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append('%');
                sb.append('0');
                sb.append('2');
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}