package com.company.goldmanSachsInterview;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/16/2019
 *         Time: 2:42 PM
 */
public class ClimbingStaircaseTest {



    @Test
    public void climbStairs() {
        int i = ClimbingStaircase.climbBruteForce(40);
        Assert.assertEquals(165580141,i);
    }

    @Test
    public void climbStairs_memo() {
        int i = ClimbingStaircase.climbBruteForceMemo(60);
        Assert.assertEquals(764848393,i);
    }

    @Test
    public void climbStairsDynamic() {
        int i = ClimbingStaircase.dynamicClimbStairs(60);
        Assert.assertEquals(764848393,i);
    }

    @Test
    public void climbStairsFibNumber() {
        int i = ClimbingStaircase.fibbonachiNumber(60);
        Assert.assertEquals(764848393,i);
    }


}