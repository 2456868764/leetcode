package com.jun.study.leetcode.dp;

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public int longest(String str) {
        int length = str.length();
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < length; i++) {
            if (str.charAt(i) == '(') {
                dp[i] = 0;
            }
            if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else {
                    int prefixIndex = i - dp[i-1] -2;
                    if (prefixIndex >= 0) {
                        dp[i] = dp[i-1] +  dp[prefixIndex] +2;
                    } else {
                        dp[i] = dp[i-1] +2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
