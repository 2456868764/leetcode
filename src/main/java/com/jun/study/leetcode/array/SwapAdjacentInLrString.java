package com.jun.study.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * medium
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */
public class SwapAdjacentInLrString {

    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }

    public boolean canTransform3(String start, String end) {
        if (start.length() != end.length()) return false;
        int rnum = 0, lnum = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R') {
                rnum++;
            }
            if (start.charAt(i) == 'L') {
                lnum--;
            }
            // if there are R need to move to right , but there are some L obstacles
            if (rnum > 0 && lnum != 0) return false;
            if (end.charAt(i) == 'R') {
                rnum--;
            }
            if (end.charAt(i) == 'L') {
                lnum++;
            }
            // there are R in right , or L in left
            if (rnum < 0 || lnum < 0) return false;
            // there are obstacles when we move R or L;
            if (rnum > 0 && lnum > 0) return false;
        }
        return rnum == 0 && lnum == 0;
    }
    public boolean canTransform2(String start, String end) {
        if (start.length() < 2 || end.length() < 2) {
            return false;
        }
        if (start.length() != end.length()) {
            return false;
        }
        if (start.equals(end)) {
            return true;
        }
        Set<String> visisted = new HashSet<>();
        return searchBFS(start, end);

    }

    private boolean searchBFS(String start, String end) {
        char[] startCh = start.toCharArray();
        char[] endCh = end.toCharArray();
        int length = startCh.length;
        int i = 0, j=0;
        while (i < length && j < length) {
            while (startCh[i] == 'X') {
                i++;
            }
            while (endCh[j] == 'X') {
                j++;
            }
            if (i < length && j < length) {
                if (startCh[i] != endCh[j]) {
                    return false;
                }
                if (startCh[i] == 'L' && i < j) {
                    return false;
                }

                if (startCh[i] == 'R' && i > j) {
                    return false;
                }
                i++;
                j++;
            }

            for (; i < length; i++) {
                if (startCh[i] == 'X') {
                    return false;
                }
            }
            for (; j < length; j++) {
                if (endCh[j] == 'X') {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        SwapAdjacentInLrString solution = new SwapAdjacentInLrString();
//        String start = "RXXLRXRXL";
//        String end = "XRLXXRRLX";
        String start = "XXRXXRXLXLXXRXRXLXXRXXLXXRXXLXXLXLRXLXRX";
        String end = "XRXRXLXLXXXRXRXXXLRLXXXXRXLXXXLXLXXXXRLR";
        boolean ok = solution.canTransform(start, end);
        System.out.println("ok=" + ok);
    }

}
