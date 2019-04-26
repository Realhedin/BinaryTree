package com.company.crackingCodeInterview.arraysAndStrings;

/**
 * @author dkorolev
 *         Date: 4/26/2019
 *         Time: 4:48 PM
 */
public class RemoveDuplicationsWithoutAdditionalMemory {

    public static void main(String[] args) {
        String str = "abcabbd";
        char[] chars = str.toCharArray();
        System.out.println(chars);
        System.out.println();
        char[] chars1 = removeDuplcatesWithNoAdditionalMemory(chars);
        System.out.println(chars1);
        String str1 = "aaaa";
        chars1 = removeDuplcatesWithNoAdditionalMemory(str1.toCharArray());
        System.out.println(chars1);
        String str2 = "aaabbbb";
        chars1 = removeDuplcatesWithNoAdditionalMemory(str2.toCharArray());
        System.out.println(chars1);
        String str3 = "abababab";
        chars1 = removeDuplcatesWithNoAdditionalMemory(str3.toCharArray());
        System.out.println(chars1);
    }


    //O(n^2)
    public static char[] removeDuplcatesWithNoAdditionalMemory(char[] chars) {
        if (chars == null) {
            return new char[0];
        }
        if (chars.length == 0 || chars.length == 1) {
            return chars;
        }

        char helper = '\0';
        for (int i = 0; i < chars.length; i++) {
            helper = chars[i];
            for (int j = i+1; j < chars.length; j++) {
                if (chars[j] == helper) {
                    chars[i] = '\0';
                }
            }
        }
      return chars;
    }


}