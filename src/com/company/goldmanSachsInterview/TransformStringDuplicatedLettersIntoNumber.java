package com.company.goldmanSachsInterview;

/**
 * @author dkorolev
 *         Date: 4/17/2019
 *         Time: 10:09 AM
 */
public class TransformStringDuplicatedLettersIntoNumber {


    //O(n)
    public static String transformString(String s) {
        int count = 0;
        char member = '\0';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == member) {
                count++;
            } else {
                if (member != '\0') {
                    sb.append(member)
                            .append(count);
                }
                member = s.charAt(i);
                count = 1;
            }
        }
        //if finished
        if (member != '\0') {
            sb.append(member)
                    .append(count);
        }
        return sb.toString();
    }

}