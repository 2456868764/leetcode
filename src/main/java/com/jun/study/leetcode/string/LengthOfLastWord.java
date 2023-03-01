package com.jun.study.leetcode.string;

/**
 * easy https://leetcode.cn/problems/length-of-last-word/
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" +");
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        String a = "   fly me   to   the moon  ";
        System.out.println("last word length=" + LengthOfLastWord.lengthOfLastWord(a));
    }
}
