package com.jun.study.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/triangle/description/
 */
public class Triangle {
    public int minimunTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row];

        for (int i = 0; i < row; i++) {
            dp[i] = triangle.get(row - 1).get(i);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
             dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }

    public int minimunTotal0928(List<List<Integer>> triangle){
        int row = triangle.size();
        int[][] dp = new int[row][row];
        for (int i = 0; i < triangle.get(row-1).size(); i++) {
            dp[row - 1][i] = triangle.get(row - 1).get(i);
        }

        for (int i = row - 2; i >=0; i--) {
            for (int j = 0; j <=i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> data = new ArrayList<>();
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        data.add(Arrays.asList(2));
        data.add(Arrays.asList(3, 4));
        data.add(Arrays.asList(6, 5, 7));
        data.add(Arrays.asList(4, 1, 8, 3));
        Triangle triangle = new Triangle();
        System.out.println("result =" + triangle.minimunTotal0928(data));
    }

}
