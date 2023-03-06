package com.jun.study.leetcode.string;

/**
 * hard: https://leetcode.cn/problems/edit-distance/
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        int row = word1.length();
        int col = word2.length();
        int[][] dp = new int[row+1][col+1];

        for (int i = 1; i <= col; i++) {
            dp[0][i] = i;
        }
        for (int j = 1; j <= row; j++) {
            dp[j][0] = j;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i][j-1])+1;
                }
            }
        }

        return dp[row][col];
    }

}
