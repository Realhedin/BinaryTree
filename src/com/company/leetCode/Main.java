package com.company.leetCode;

public class Main {
    public static void main(String[] args) {
        LongSubWioutRepeat longSubWioutRepeat = new LongSubWioutRepeat();
        System.out.println(longSubWioutRepeat.lengthOfLongestSubstringSlidingWindow("ababcad"));
        System.out.println(longSubWioutRepeat.longestSlidingWindowString("ababcad"));

        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.findMaxConsecutivOnesSlidingWindowFastCatchup(new int[] {1,0,1,1,0,1}));

        HouseRobber houseRobber = new HouseRobber();
        System.out.println("House Robbery problem: " + houseRobber.rob(new int[]{1, 3, 8, 5, 2}));

        TrappingRainWater rainWater = new TrappingRainWater();
        System.out.println("Trapped rain water problem, Dynamic simple:"
                + rainWater.trapRainWaterDynamicProgramming(new int[] {4,2,0,3,2,5}));
        System.out.println("Trapped rain water problem, Sliding window:"
                + rainWater.trapRainWaterSlidingWindow(new int[] {4,2,0,3,2,5}));

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println("Minimum window substring: "
                + minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));


        FourSumCount fourSumCount = new FourSumCount();
        System.out.println("Four sum count 2: " +
                +fourSumCount.fourSumCountMethod(new int []{1,2},
                        new int[]{-2,-1},
                        new int[]{-1,2},
                        new int[]{0,2}));


        ShiftingLetters shiftingLetters = new ShiftingLetters();
        System.out.println("Shifting letters: "
            + shiftingLetters.shiftingLetters("abc", new int[]{3, 5, 9}));

        //create cache for capacity = 2
        System.out.println("\nLeast Recently Used cache: ");
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1); //added
        lruCache.put(2, 2); //added
        System.out.println(lruCache.get(1)); //return one
        lruCache.put(3,3); //2 removed, 3 added
        System.out.println(lruCache.get(2)); //return -1
        lruCache.put(4, 4); //1 removed, 4 added
        System.out.println(lruCache.get(1)); // return -1
        System.out.println(lruCache.get(3)); //return 3
        System.out.println(lruCache.get(4)); // return 4
    }
}
