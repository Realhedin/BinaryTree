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
     * Having one run though array by adjustin left and right indexes.
     * We dynamically compare leftMax and RightMax to calculate
     * trapped water on smaller side.
     *
     * @param height - array of incoming structure.
     * @return sum of trapped water.
     */
    public int trapRainWaterSlidingWindow(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length -1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (leftIndex < rightIndex) {
            //compare index elements
            if (height[leftIndex] < height[rightIndex]) {
                if (height[leftIndex] > leftMax) {
                    //if element > leftMax, set it as max
                    leftMax = height[leftIndex];
                } else {
                    //otherwise, calculate as difference between leftmax and current height
                    trappedWater += leftMax - height[leftIndex];
                }
                //move left index to the right
                leftIndex++;
            } else {
                //the same as above but for rightIndex
                if (height[rightIndex] > rightMax) {
                    rightMax = height[rightIndex];
                } else {
                    trappedWater += rightMax - height[rightIndex];
                }
                //move right index to the left
                rightIndex--;
            }
        }
        return trappedWater;
    }



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
