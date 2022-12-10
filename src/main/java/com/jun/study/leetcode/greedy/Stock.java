package com.jun.study.leetcode.greedy;

public class Stock {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i + 1] > prices[i]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Stock stock = new Stock();
        System.out.println("max profit=" + stock.maxProfit(prices));
    }
}
