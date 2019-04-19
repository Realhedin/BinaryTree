package com.company.leetCode;

import java.util.Arrays;

/**
 * @author dkorolev
 *         Date: 3/29/2019
 *         Time: 2:34 PM
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
                if (nums[i] + nums[j] > target) {
                    break;
                }
            }
        }
        return indices;
    }
}