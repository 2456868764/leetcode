package com.jun.study.leetcode.string;

/**
 * easy: https://leetcode.cn/problems/reverse-string/
 */
public class ReverseString {

    public void reverse(char[] s) {

        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
        }

    }
}
