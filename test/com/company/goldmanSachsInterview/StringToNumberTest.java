package com.company.goldmanSachsInterview;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/19/2019
 *         Time: 12:39 PM
 */
public class StringToNumberTest {

    @Test
    public void testStringToNumber() {
        String str = "";
        Long aLong = StringToNumber.stringToNumber(str);
        Assert.assertEquals(0L,(long)aLong);
    }


    @Test
    public void testStringToNumber_2() {
        String str = "afsjld";
        Long aLong = StringToNumber.stringToNumber(str);
        Assert.assertEquals(Long.MIN_VALUE,(long)aLong);
    }


    @Test
    public void testStringToNumber_3() {
        String str = "1235";
        Long aLong = StringToNumber.stringToNumber(str);
        Assert.assertEquals(1235L,(long)aLong);
    }


    @Test
    public void testStringToNumber_4() {
        String str = "1235150815098598159081591341934718347918947894748934791898971389478937897897138941897889718947892738919348";
        Long aLong = StringToNumber.stringToNumber(str);
        Assert.assertEquals(Long.MIN_VALUE,(long)aLong);
    }

    @Test
    public void testStringToNumber_6() {
        String str = null;
        Long aLong = StringToNumber.stringToNumber(str);
        Assert.assertEquals(0L,(long)aLong);
    }
}