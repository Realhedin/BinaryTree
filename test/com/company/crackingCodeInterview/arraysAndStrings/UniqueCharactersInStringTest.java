package com.company.crackingCodeInterview.arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/19/2019
 *         Time: 1:46 PM
 */
public class UniqueCharactersInStringTest {

    @Test
    public void check1() {
        String s = null;
        boolean b = UniqueCharactersInString.isUniqueChars2(s);
        Assert.assertEquals(false, b);
    }

    @Test
    public void check2() {
        String s = "";
        boolean b = UniqueCharactersInString.isUniqueChars2(s);
        Assert.assertEquals(true, b);
    }

    @Test
    public void check3() {
        String s = "abc";
        boolean b = UniqueCharactersInString.isUniqueChars2(s);
        Assert.assertEquals(true, b);
    }

    @Test
    public void check4() {
        String s = "abcadsfdasfdasfdasfdasfs";
        boolean b = UniqueCharactersInString.isUniqueChars2(s);
        Assert.assertEquals(false, b);
    }
}