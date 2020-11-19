package com.company.leetCode;

public class Main {
    public static void main(String[] args) {
        LongSubWioutRepeat longSubWioutRepeat = new LongSubWioutRepeat();
        System.out.println(longSubWioutRepeat.lengthOfLongestSubstringSlidingWindow("ababcad"));
        System.out.println(longSubWioutRepeat.longestSlidingWindowString("ababcad"));

        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.findMaxConsecutivOnesSlidingWindowFastCatchup(new int[] {1,0,1,1,0,1}));
    }
}
