package com.jun.study.leetcode.array;

/**
 * https://leetcode.cn/problems/rotate-array/solution/
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i+k) % nums.length] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }
}
