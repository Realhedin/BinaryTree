package com.company.leetCode;

/**
 * You need to rob houses to get max money, but cannot rob
 * adjacent houses (which side-by-side).
 */
public class HouseRobber {

    /**
     * approach is following:
     * we iterate through array and comparing max(cur + cur-2, cur-1)
     * (because we cannot rob adjucent houses)
     * then move values accordingly.
     * Example [1,3,8,5,2]
     * => [1,3,9,9,11] => 11 is max sum we can rob here.
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int slowest = nums[0];
        int slow = Math.max(nums[0], nums[1]);
        int fast = 0;

        for (int i = 2; i < nums.length; i++) {
            fast = Math.max(nums[i] + slowest, slow);
            slowest = slow;
            slow = fast;
        }
        return fast;
    }
}
