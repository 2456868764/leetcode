package com.jun.study.leetcode.google.day29;

import java.util.*;

/**
 * hard
 * https://leetcode.cn/problems/shortest-path-in-a-grid-with-obstacles-elimination
 */
public class ShortestPathInAGrid {

    public int shortestPath(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;
        Deque<Data> queue = new ArrayDeque<>();
        Set<Data> vistied = new HashSet<>();
        queue.push(new Data(0, 0, k));
        vistied.add(new Data(0, 0, k));
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step = 0;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            step++;
            for (int i = 0; i < cnt; i++) {
                Data pop = queue.pop();
                int x = pop.x, y = pop.y, rest = pop.rest;
                // four direction detect
                for (int m = 0; m < direction.length; m++) {
                        int newx = direction[m][0] + x;
                        int newy = direction[m][1] + y;
                        if (newx >= 0 && newx < row && newy >= 0 && newy < col) {
                            Data tmpData = new Data(newx, newy, rest);
                            if (grid[newx][newy] == 0  && !vistied.contains(tmpData)) {
                                if (newx == row - 1 && newy == col - 1) {
                                    return step;
                                }
                                queue.addLast(tmpData);
                                vistied.add(tmpData);
                            }
                            if (grid[newx][newy] == 1 && rest > 0) {
                                Data tmpData2 = new Data(newx, newy, rest - 1);
                                if (!vistied.contains(tmpData2)) {
                                    queue.addLast(tmpData2);
                                    vistied.add(tmpData2);
                                }
                            }


                        }
                }


            }
        }

        return -1;

    }

    static class Data {
        int x;
        int y;
        int rest;

        public Data(int x, int y, int rest) {
            this.x = x;
            this.y = y;
            this.rest = rest;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return x == data.x && y == data.y && rest == data.rest;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, rest);
        }
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 1, 1}, {0, 1, 0}};
        ShortestPathInAGrid solution = new ShortestPathInAGrid();
        int step = solution.shortestPath(grid, 1);
        System.out.println("step =" + step);

    }

}
