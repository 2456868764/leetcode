package com.jun.study.leetcode.dp;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
 */
public class BestTimeBuy1 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        //dp[i][0]: 表示第i天没有股票收益
        //dp[i][1]: 表示第i天有股票收益
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
        }
        return dp[n - 1][0];
    }


}
