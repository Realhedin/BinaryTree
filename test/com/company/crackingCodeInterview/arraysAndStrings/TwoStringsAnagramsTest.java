package com.company.crackingCodeInterview.arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/19/2019
 *         Time: 5:47 PM
 */
public class TwoStringsAnagramsTest {


    @Test
    public void checkForAnagrams_1() {
        String s1 = "listen";
        String s2 = "silent";
        boolean b = TwoStringsAnagrams.checkAnagram(s1, s2);
        Assert.assertEquals(true,b);
    }


    @Test
    public void checkForAnagrams_2() {
        String s1 = "linten";
        String s2 = "silent";
        boolean b = TwoStringsAnagrams.checkAnagram(s1, s2);
        Assert.assertEquals(false,b);
    }
}