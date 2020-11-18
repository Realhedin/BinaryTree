package com.company.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dkorolev
 *         Date: 3/29/2019
 *         Time: 3:02 PM
 */
public class LongSubWioutRepeat {
    public int lengthOfLongestSubstring(String s) {
        char[] sList = s.toCharArray();
        int longestSub = 0;
        int help = 0;
        Set sub = new HashSet();
        for (char ch : sList) {
            if (!sub.contains(ch)) {
                sub.add(ch);
                help++;
            } else {
                if (help>longestSub) {
                    longestSub = help;
                    sub.clear();
                    sub.add(ch);
                    help=1;
                } else {
                    sub.clear();
                    sub.add(ch);
                    help = 1;
                }
            }
        }
        if (help > longestSub) {
            longestSub=help;
        }
        return longestSub;
    }




    public int lengthOfLongestSubstringSlidingWindow(String s) {
        Set<Character> sub = new HashSet<>();
        int maxInt = 0;
        int i=0;
        int j=0;
        while (i < s.length() && j < s.length()) {
            if (!sub.contains(s.charAt(j))) {
                sub.add(s.charAt(j++));
                maxInt = Math.max(maxInt, j - i);
            } else {
                sub.remove(s.charAt(i++));
            }
        }
        return maxInt;
    }


    public String longestSlidingWindowString(String s) {
        Set<Character> unique = new HashSet<>();
        String str = "";
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (!unique.contains(s.charAt(j))) {
                unique.add(s.charAt(j++));
                str = str.length() > s.substring(i, j).length() ? str : s.substring(i, j);
            } else {
                unique.remove(s.charAt(i++));
            }
        }
        return str;
    }
}