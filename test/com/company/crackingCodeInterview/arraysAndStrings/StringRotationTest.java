package com.company.crackingCodeInterview.arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/25/2019
 *         Time: 4:58 PM
 */
public class StringRotationTest {

    @Test
    public void testRotation() {
        String str1 = "apple";
        String str2 = "pleap";
        boolean actual = StringRotation.compareRotation(str1, str2);
        Assert.assertEquals(true, actual);
    }

    @Test
    public void testRotationDiff() {
        String str1 = "apple1";
        String str2 = "pleap";
        boolean actual = StringRotation.compareRotation(str1, str2);
        Assert.assertEquals(false, actual);
    }

    @Test
    public void testRotationNull() {
        String str1 = null;
        String str2 = "pleap";
        boolean actual = StringRotation.compareRotation(str1, str2);
        Assert.assertEquals(false, actual);
    }

    @Test
    public void testRotationEmpty() {
        String str1 = "";
        String str2 = "pleap";
        boolean actual = StringRotation.compareRotation(str1, str2);
        Assert.assertEquals(false, actual);
    }
}