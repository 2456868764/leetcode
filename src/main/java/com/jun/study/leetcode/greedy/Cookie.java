package com.jun.study.leetcode.greedy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class Cookie {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int result = 0;
        for (int i = 0; i < s.length && index < g.length; i++) {
            if (s[i] >= g[index]) {
                result++;
                index++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        Cookie cookie = new Cookie();
        System.out.println("result=" + cookie.findContentChildren(g, s));

    }
}
