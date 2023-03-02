package com.jun.study.leetcode.string;

/**
 * easy： https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInAString3 {
    public static String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] chs = words[i].toCharArray();
            for (int j = 0, p = chs.length - 1; i < p ; j++, p--) {
                char ch = chs[j];
                chs[j] = chs[p];
                chs[p] = ch;
            }
            sb.append(chs);
            if (i < words.length - 1) {
                sb.append(" ");
            }

        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
