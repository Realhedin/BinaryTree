package com.company.goldmanSachsInterview;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/17/2019
 *         Time: 10:17 AM
 */
public class TransformStringDuplicatedLettersIntoNumberTest {

    @Test
    public void transformString_empty() {
       String incStr = "";
        String actual = TransformStringDuplicatedLettersIntoNumber.transformString(incStr);
        Assert.assertEquals("", actual);
    }

    @Test
    public void transformString_1() {
        String incStr = "a";
        String actual = TransformStringDuplicatedLettersIntoNumber.transformString(incStr);
        Assert.assertEquals("a1", actual);
    }

    @Test
    public void transformString_2() {
        String incStr = "aaa";
        String actual = TransformStringDuplicatedLettersIntoNumber.transformString(incStr);
        Assert.assertEquals("a3", actual);
    }


    @Test
    public void transformString_3() {
        String incStr = "aaabbc";
        String actual = TransformStringDuplicatedLettersIntoNumber.transformString(incStr);
        Assert.assertEquals("a3b2c1", actual);
    }

    @Test
    public void transformString_4() {
        String incStr = "aaabbdcccccf";
        String actual = TransformStringDuplicatedLettersIntoNumber.transformString(incStr);
        Assert.assertEquals("a3b2d1c5f1", actual);
    }

    @Test
    public void transformString_5() {
        String incStr = "aabbaa";
        String actual = TransformStringDuplicatedLettersIntoNumber.transformString(incStr);
        Assert.assertEquals("a2b2a2", actual);
    }
}