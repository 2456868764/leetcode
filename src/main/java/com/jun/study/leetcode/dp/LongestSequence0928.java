package com.jun.study.leetcode.dp;

public class LongestSequence0928 {

    public int longestCommonSubSequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            char chrow = text1.charAt(i-1);
            for (int j = 1; j <= col; j++) {
                char chcol = text2.charAt(j - 1);
                if (chrow == chcol) {
                    dp[i][j] = dp[i - 1][j - 1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        LongestSequence0928 longestSequence = new LongestSequence0928();
        int result = longestSequence.longestCommonSubSequence("abcde", "ace");
        System.out.println("result = " + result);

    }

}
