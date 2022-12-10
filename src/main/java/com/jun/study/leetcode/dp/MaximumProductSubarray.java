package com.jun.study.leetcode.dp;

public class MaximumProductSubarray {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            dp[i] = (dp[i - 1] * nums[i]) > 0 ? (dp[i - 1] * nums[i]) : nums[i];
            max = Math.max(dp[i], max);

        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        MaximumProductSubarray maximumSubarray = new MaximumProductSubarray();
        System.out.println("max = " + maximumSubarray.maxSubArray(nums));
    }
}
