package com.company.goldmanSachsInterview;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/16/2019
 *         Time: 11:01 AM
 */
public class FindSecondMinInArrayOfNumbersTest {

    @Test
    public void findSecondMin_basic() {
        int[] arr = {3, 4, 6, 2, 1, 5};
        int actualValue = FindSecondMinInArrayOfNumbers.findSecondMin_basic(arr);
        assertEquals(2,actualValue);
    }


    @Test
    public void findSecondMin_basic2() {
        int[] arr = {3, -4, 6, 2, 1, 5};
        int actualValue = FindSecondMinInArrayOfNumbers.findSecondMin_basic(arr);
        assertEquals(1,actualValue);
    }


    @Test
    public void findSecondMin_basic3() {
        int[] arr = {-6, -2, 6, 2, 1, -5};
        int actualValue = FindSecondMinInArrayOfNumbers.findSecondMin_basic(arr);
        assertEquals(-5,actualValue);
    }

    @Test (expected = RuntimeException.class)
    public void findSecondMin_neg() {
        int[] arr = {1};
        FindSecondMinInArrayOfNumbers.findSecondMin_basic(arr);
    }
}
