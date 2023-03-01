package com.jun.study.leetcode.google.day31;

import java.util.HashMap;
import java.util.Map;

public class AmountOfNewAreaPaintedEachDay {

    public int[] paintEachDay(int[][] paint) {
        int days = paint.length;
        int[] res = new int[days];
        Map<Integer, Integer> painted = new HashMap<>();
        for (int i = 0; i < days; i++) {
            int[] works = paint[i];
            int work = 0;
            int start = works[0], end = works[1];
            while (start < end) {
                if (painted.containsKey(start)) {
                    int prev_end = painted.get(start);
                    painted.put(start, Math.max(painted.get(start), end));
                    start = prev_end;
                } else {
                    painted.put(start, end);
                    start++;
                    work++;

                }
            }
            res[i] = work;

        }

        return res;


    }
}
