package com.company.crackingCodeInterview.arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/26/2019
 *         Time: 4:59 PM
 */
public class RemoveDuplicationsWithoutAdditionalMemoryTest {

    @Test
    public void testRemoveDupl_1() {
       String str = "abcd";
        char[] actualValues = RemoveDuplicationsWithoutAdditionalMemory.removeDuplcatesWithNoAdditionalMemory(str
                .toCharArray());
        Assert.assertEquals("abcd".length(), actualValues.length);
    }

    @Test
    public void testRemoveDupl_2() {
        String str = "aaaa";
        char[] actualValues = RemoveDuplicationsWithoutAdditionalMemory.removeDuplcatesWithNoAdditionalMemory(str
                .toCharArray());
        Assert.assertEquals("a".toCharArray().length, actualValues.length);
    }

    @Test
    public void testRemoveDupl_3() {
        char[] str = null;
        char[] actualValues = RemoveDuplicationsWithoutAdditionalMemory.removeDuplcatesWithNoAdditionalMemory(str);
        Assert.assertEquals(new char[0], actualValues.length);
    }

    @Test
    public void testRemoveDupl_4() {
        String str = "aaabbb";
        char[] actualValues = RemoveDuplicationsWithoutAdditionalMemory.removeDuplcatesWithNoAdditionalMemory(str
                .toCharArray());
        Assert.assertEquals("ab".toCharArray().length, actualValues.length);
    }

    @Test
    public void testRemoveDupl_5() {
        String str = "abababa";
        char[] actualValues = RemoveDuplicationsWithoutAdditionalMemory.removeDuplcatesWithNoAdditionalMemory(str
                .toCharArray());
        Assert.assertEquals("ab".toCharArray().length, actualValues.length);
    }
}