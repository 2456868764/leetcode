package com.jun.study.leetcode.subproblem;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * @author jun
 */
public class NQueens {

    private Set<Integer> cols;
    private Set<Integer> mains;
    private Set<Integer> subs;

    private List<List<String>> result;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new HashSet<>();
        mains = new HashSet<>();
        subs = new HashSet<>();
        result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();

        dfs(0, path);
        return result;
    }

    private void dfs(int row, Deque<Integer> path) {
        //terminator
        if (row == n) {
            result.add(printGraph(path));
            return;
        }


        for (int i = 0; i < n; i++) {
            if (!cols.contains(i) && !mains.contains(row + i) && !subs.contains(row - i)) {
                //process
                path.addLast(i);
                cols.add(i);
                mains.add(row + i);
                subs.add(row - i);

                //drill down to sub problem
                dfs(row + 1, path);

                //reserve state
                cols.remove(i);
                mains.remove(row + i);
                subs.remove(row - i);
                path.removeLast();
            }

        }

    }

    private List<String> printGraph(Deque<Integer> path) {
        List<String> graph = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(".");
            }
            row.replace(num, num + 1, "Q");
            graph.add(row.toString());
        }

        return graph;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> result = nQueens.solveNQueens(4);
        System.out.println(result);
    }
}
