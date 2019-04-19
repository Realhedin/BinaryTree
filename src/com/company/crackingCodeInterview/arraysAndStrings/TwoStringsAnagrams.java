package com.company.crackingCodeInterview.arraysAndStrings;

import java.util.Arrays;

/**
 * @author dkorolev
 *         Date: 4/19/2019
 *         Time: 5:46 PM
 */
public class TwoStringsAnagrams {

    public static boolean checkAnagram(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        if (Arrays.equals(charArray1, charArray2)) {
            return true;
        }
        return false;
    }
}