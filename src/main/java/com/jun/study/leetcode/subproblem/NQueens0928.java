package com.jun.study.leetcode.subproblem;

import java.util.*;

public class NQueens0928 {

    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> mains = new HashSet<>();
        Set<Integer> subs = new HashSet<>();
        Deque<Integer> path = new ArrayDeque<>();
        List<List<String>> results = new ArrayList<>();
        solve(0, n, cols, mains, subs, path, results);
        return results;
    }

    private void solve(int row, int n, Set<Integer> cols, Set<Integer> mains, Set<Integer> subs, Deque<Integer> path, List<List<String>> results) {
        if (row == n) {
            results.add(output(path, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || mains.contains(row + i) || subs.contains(row - i)) {
                continue;
            }

            path.addLast(i);
            cols.add(i);
            mains.add(row + i);
            subs.add(row - i);

            solve(row + 1, n, cols, mains, subs, path, results);

            //restore status

            path.removeLast();
            cols.remove(i);
            mains.remove(row + i);
            subs.remove(row - i);
        }


    }

    private List<String> output(Deque<Integer> path, Integer n) {
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
        NQueens0928 nQueens = new NQueens0928();
        List<List<String>> result = nQueens.solveNQueens(8);
        System.out.println(result);
    }

}
