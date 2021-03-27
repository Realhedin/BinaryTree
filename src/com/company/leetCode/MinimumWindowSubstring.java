package com.company.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 *  Find minimum substring containing all symbols from String T
 *  in big String S.
 *  Create 2 dictionaries: one contains necessary symbols with number of them from T,
 *  second one is prepared to be filled during algorithm.
 *  counter indicates that how many symbols do we still need to find
 *
 *  Algorithm (sliding window):
 *  we iterate through string S, adding elements into dictionary,
 *  until counter > 0 increasing right pointer.
 *  When it becomes 0,
 *  we start to schrink our current window, by moving left pointer and
 *  check if counter is still 0 and number of elements in requiredDictionary is still enough.
 *
 *  https://leetcode.com/problems/minimum-window-substring/
 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        //simple case
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        if (t.length() > s.length()) {
            return "";
        }


        //needed number of each symbol
        Map<Character, Integer> requiredDictionary = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            requiredDictionary.merge(t.charAt(i), 1, Integer::sum);
        }

        //fill dictionary to check necessary number of characters
        Map<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            dictionary.put(t.charAt(i), 0);
        }

        //counter to needed size, if 0 - then we are fine
        int counter = t.length();

        //left and right pointers
        int l = 0, r = 0;

        //current optimal substring window
        // 0 - size, 1 - left pointer, 2 - right pointer
        int[] subWindow = new int[3];
        subWindow[0] = Integer.MAX_VALUE;

        //algo
        while (r < s.length()) {
            //take next symbol
            char c = s.charAt(r);
            Integer existingValue = dictionary.get(c);
            Integer requiredNumber = requiredDictionary.get(c);
            if (existingValue == null) {
                r++;
                continue;
            } else if (existingValue < requiredNumber) {
                dictionary.put(c, existingValue+1);
                counter--;
            } else {
                dictionary.put(c, existingValue + 1);
                r++;
                continue;
            }

            //check counter
            if (counter == 0) {
                //that means we have all necessary symbols in our subWindow
                //now we can shrink it
                while (l <= r && counter == 0) {
                    c = s.charAt(l);
                    //save as a smallest subWindow
                    if (r - l < subWindow[0]) {
                        subWindow[0] = r - l;
                        subWindow[1] = l;
                        subWindow[2] = r;
                    }
                    //check if dictionary has this symbol
                    if (dictionary.containsKey(c)) {
                        existingValue = dictionary.get(c);
                        if (existingValue <= requiredDictionary.get(c)) {
                            counter++;
                        }
                        dictionary.put(c, existingValue - 1);
                    }

                    l++;
                }
            }
            r++;
        }
        //didn't find matches
        if (subWindow[0] == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(subWindow[1], subWindow[2]+1);
    }
}