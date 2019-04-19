package com.company.crackingCodeInterview.arraysAndStrings;

/**
 * @author dkorolev
 *         Date: 4/19/2019
 *         Time: 1:07 PM
 */
public class UniqueCharactersInString {

//    public static boolean checkIfUniqueCharacters(String s) {
//        if (s!=null) {
//            if (s.length() == 0 || s.length() == 1) {
//                return true;
//            }
//            HashSet hashSet = new HashSet(Arrays.asList(s.toCharArray()));
//            if (s.length() == hashSet.size()) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean isUniqueChars2(String str) {
        if (str != null) {
            if (str.length() == 0 || str.length() == 1) {
                return true;
            }
            //num of chars
            boolean[] char_set = new boolean[256];
            for (int i = 0; i < str.length(); i++) {
                int val = str.charAt(i);
                if (char_set[val]) {
                    return false;
                }
                char_set[val] = true;
            }
            return true;
        }
        return false;
    }
}