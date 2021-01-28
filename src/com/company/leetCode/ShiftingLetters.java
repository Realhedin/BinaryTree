package com.company.leetCode;

/**
 * Goal is to move chars in S string right to n positions from shifts array.
 * 1st character is moved by n positions based on 1st array element,
 * then 1st and 2nd characters are moved by 2nd array elements and so forth.
 */
public class ShiftingLetters {

    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder sb = new StringBuilder(S.length());
        //update shift elements to proper number of character move
        for (int i = shifts.length-2; i >=0 ; i--) {
            shifts[i] = (shifts[i] + shifts[i+1]) % 26;
        }
        //get character, subtract beginning 'a' character, then shift character into int,
        //after that we take remainder from 26 (all number of symbols) and then reapply 'a'
        for (int i = 0; i < S.length(); i++) {
            sb.append((char)((S.charAt(i) - 'a' + shifts[i]) % 26 + 'a'));
        }
        return sb.toString();
    }
}
