package com.jun.study.leetcode.dp;

/**
 * https://leetcode.cn/problems/longest-common-subsequence/
 */
public class LongestSequence {

    public int longestCommonSubSequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <=row; i++) {
            char ci = text1.charAt(i-1);
            for (int j = 1; j <= col; j++) {
                char cj = text2.charAt(j - 1);
                if (ci == cj) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[row][col];

    }

    public static void main(String[] args) {
        LongestSequence longestSequence = new LongestSequence();
        int result = longestSequence.longestCommonSubSequence("abcde", "ace");
        System.out.println("result = " + result);

    }
}
