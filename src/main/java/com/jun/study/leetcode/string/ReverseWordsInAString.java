package com.jun.study.leetcode.string;

import java.util.Arrays;
import java.util.Collections;

/**
 * medium: https://leetcode.cn/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
