package com.company;

import com.company.leetCode.ArrayIntoTree;
import com.company.leetCode.LongSubWioutRepeat;
import com.company.leetCode.TwoSum;

/**
 * @author dkorolev
 *         Date: 3/29/2019
 *         Time: 2:35 PM
 */
public class MainForLeetCode {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] sum = new int[]{1, 2, 5, 8, 7, 11, 15};
        int[] ints = twoSum.twoSum(sum, 9);
        System.out.println(ints);


        System.out.println();
        LongSubWioutRepeat longSubWioutRepeat = new LongSubWioutRepeat();
//        int i = longSubWioutRepeat.lengthOfLongestSubstring("dvdf");
        int i = longSubWioutRepeat.lengthOfLongestSubstringSlidingWindow("abcabcbb");
        System.out.println(i);


        System.out.println("\n");
        ArrayIntoTree arrayIntoTree = new ArrayIntoTree();
        int[] ints1 = new int[]{0, 1,2,3,4,5};
//        ArrayIntoTree.TreeNode treeNode = arrayIntoTree.sortedArrayToBST(ints1);
        ArrayIntoTree.TreeNode treeNode = arrayIntoTree.sortedArrayToBST2(ints1);
        System.out.println(treeNode);
    }
}