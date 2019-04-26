package com.company.crackingCodeInterview.arraysAndStrings;

/**
 * @author dkorolev
 *         Date: 4/25/2019
 *         Time: 4:57 PM
 */
public class StringRotation {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "pleap";

        boolean b = compareRotation(str1, str2);
        System.out.println(b);

    }
    public static boolean compareRotation(String str1, String str2) {
        if (str1==null || str2==null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        //add rotated, then right name should be inside s1+s1
        String newStr = str1+str1;
        return (isSubstring(newStr, str2));
    }

    private static boolean isSubstring(String newStr, String str2) {
        return newStr.contains(str2);
    }
}