package com.jun.study.leetcode.dp;

/**
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < size; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println("max="+maximumSubarray.maxSubArray(nums));
    }

}
