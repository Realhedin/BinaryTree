package com.company.goldmanSachsInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dkorolev
 *         Date: 4/16/2019
 *         Time: 12:11 PM
 */

public class LongestDictWordsFromCharacters {

        //summary with O(n^2)
    public static List<String> chooseLongestWords(Character[] chars, String[] dict) {
        List<String> stringList = new ArrayList<>();
        //fill list (O(n^2)
        for (String s : dict) {
            boolean cont = true;
            for (Character ch : chars) {
                if (!s.contains(ch.toString())) {
                    cont = false;
                    break;
                }
            }
            if (cont) {
                stringList.add(s);
            }
        }

        // add to new final list O(n)
        List<String> finalList = new ArrayList<>();
        String tempMax = "";
        for (String s : stringList) {
            if (s.length() >= tempMax.length()) {
                tempMax = s;
                finalList.add(s);
            }
        }
        return finalList;
    }






    public static String chooseLongestWords2(String s, List<String> d) {
        char[] chars = s.toCharArray();
        String longestString = "";
        for (String word : d) {
            boolean check = false;
            for (char c : word.toCharArray()) {
                check = false;
                for (Character ch : chars) {
                    if (ch.equals(c)) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    break;
                }
            }
            if (check) {
                if (word.length() > longestString.length()) {
                    longestString = word;
                } else if(word.length() == longestString.length() && word.compareTo(longestString) < 0) {
                    longestString = word;
                }
            }

        }
        return longestString;
    }



    //complexity O(n*lg(n) + O(x)
    public static String chooseLongestWords3Sorting(String str, List<String> dict) {
        //sort str and dict O(n*x lg(n)), n - list<String>.length(), x - string length
        Collections.sort(dict, (s1,s2)-> {
            return s2.length()!= s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
        });

        //now we check sequence O(n*x)
        for (String s : dict) {
            if (isSubsequence(str, s)) {
                return s;
            }
        }
        return "";
    }



    // O(n*x), n - list of String, x - average length
    public static String chooseLongestWords4WithoutSorting(String str, List<String> dict) {
        String max_str = "";
        for (String s : dict) {
            if (isSubsequence(str, s)) {
                if (s.length() > max_str.length() || (s.length() == max_str.length() && s.compareTo(max_str) < 0)) {
                    max_str = s;
                }
            }
        }
        return max_str;
    }





    private static boolean isSubsequence(String str, String word) {
        int j=0;
        for (int i = 0; i < str.length(); i++) {
            if (word.charAt(j) == str.charAt(i)) {
                j++;
            }
            if (j == word.length()) {
                return true;
            }
        }
        return false;
    }
}