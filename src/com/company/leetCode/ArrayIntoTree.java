package com.company.leetCode;

/**
 * @author dkorolev
 *         Date: 3/29/2019
 *         Time: 5:34 PM
 */
public class ArrayIntoTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode tree = new TreeNode(nums[(nums.length-1)/2]);
        int[] nums2 = new int[nums.length-1];
        int j=0;
        //preparation
        for (int i=0; i<nums.length; i++) {
            if (i!=(nums.length-1)/2) {
                nums2[j++] = nums[i];
            }
        }
        //adding
        for (int i=0; i<nums2.length; i++) {
            add(tree, nums2[i]);
        }
        return tree;
    }

    public void add(TreeNode top, int value) {
        TreeNode y = null;
        TreeNode x = top;
        while(x!=null) {
            if (value<x.val) {
                y = x;
                x = x.left;
            } else {
                y = x;
                x = x.right;
            }
        }
        TreeNode newNode = new TreeNode(value);
        if (value<y.val) {
            y.left = newNode;
        } else {
            y.right = newNode;
        }

    }

    //////////////////////////
    public TreeNode sortedArrayToBST2(int[] num) {
        if (num.length == 0)
            return null;

        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);

        return root;
    }


    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}