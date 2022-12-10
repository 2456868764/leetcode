package com.jun.study.leetcode.dp;

public class CountPaths {

    public int countPathsBottomDown(boolean[][] grid, int row, int col) {
        if (!validGrid(grid, row, col)) {
            return 0;
        }

        if (isAtEnd(grid, row, col)) {
            return 1;
        }

        return countPathsBottomDown(grid, row + 1, col) + countPathsBottomDown(grid, row, col + 1);

    }

    private boolean isAtEnd(boolean[][] grid, int row, int col) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        if (row >= maxRow || col >= maxCol) {
            return false;
        }

        if (grid[row][col]) {
            return false;
        }

        return true;
    }

    private boolean validGrid(boolean[][] grid, int row, int col) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        if (row == maxRow - 1 && col == maxCol - 1) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {

    }

}
