package com.jun.study.leetcode.bfsdfs;


import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/number-of-islands/
 */
public class NumberOfIslands {

    public int numIslands(String[][] grid) {
        Set<String> visited = new HashSet<>();
        int nums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if ("1".equals(grid[i][j]) && !visited.contains(String.valueOf(i) + ":" + String.valueOf(j))) {
                    nums++;
                    floodFill(i, j, visited, grid);
                }
            }
        }
        return nums;
    }

    private void floodFill(int i, int j, Set<String> visited, String[][] grid) {
        if (i >= grid.length || j >= grid[i].length) {
            return;
        }
        if ("0".equals(grid[i][j])) {
            return;
        }
        if (visited.contains(String.valueOf(i) + ":" + String.valueOf(j))) {
            return;
        }
        visited.add(String.valueOf(i) + ":" + String.valueOf(j));
        floodFill(i + 1, j, visited, grid);
        floodFill(i, j + 1, visited, grid);
    }


    public static void main(String[] args) {
        String[][] grid = {
                {"1", "1", "1", "1", "0"},
                {"1", "0", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"1", "0", "1", "0", "1"},
                {"1", "0", "1", "0", "1"}
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int nums = numberOfIslands.numIslands(grid);
        System.out.println("nums：" + nums);
    }

}
