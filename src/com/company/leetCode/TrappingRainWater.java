package com.company.leetCode;

/**
 * Given n non-negative integers (array) representing elemvation map where
 * width of each bar is 1, compute how much water it can trap after raining.
 *
 * |      _    _
 * |  _  | |__| |
 * |_| |_|      |
 */
public class TrappingRainWater {

    /**
     * We iterate from left to right to save leftMax per each element in array.
     * Then iterate from right to left.
     * Then sum of trapped water will be minimum
     * between leftMax and rightMax - height of array element.
     *
     * @param height - array of incoming structure.
     * @return sum of trapped water.
     */
    public int trapRainWaterDynamicProgramming(int[] height) {
        int size = height.length;
        if (size == 0) {
            return 0;
        }

        int trappedWater = 0;
        int[] leftMax = new int[size];
        //iterate from left to right (setting max values between current height and previous max)
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[size];
        //iterate from right to left
        rightMax[size - 1] = height[size - 1];
        for (int i = size-2; i > 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        //calculate trapped water as min between leftMax and rightMax
        // and subtract height itself
        //1st and last excluded as borders
        for (int i = 1; i < size-1; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trappedWater;
    }
}
