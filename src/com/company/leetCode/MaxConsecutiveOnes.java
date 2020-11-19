package com.company.leetCode;

public class MaxConsecutiveOnes {

    //Use sliding window fast/catchup example
    // (see medium.com/outco/how-to-solve-sliding-window-prolems-28d67601a66 )
    public int findMaxConsecutivOnesSlidingWindowFastCatchup(int[] nums) {
        int sum = 0;
        int i=0;
        int j=0;
        while (i < nums.length && j < nums.length) {
            if (nums[j] == 1) {
                j++;
            } else {
                j++;
                i=j;
            }
            sum = Math.max(sum, j - i);
        }
        return sum;
    }
}
