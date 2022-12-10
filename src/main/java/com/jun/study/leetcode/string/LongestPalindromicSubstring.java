package com.jun.study.leetcode.string;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        int maxLen = 0;
        int startPos = 0;
        int endPos = 0;
        for (int i = 1; i < len-1; i++) {
            int left = i-1, right = i+1;
            while(left >=0 && right < len){
                if (s.charAt(left) == s.charAt(right)) {
                    int curLen = right - left +1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        startPos = left;
                        endPos = right;
                    }
                } else {
                    break;
                }
                left--;
                right++;
            }
        }

        for (int i = 0; i < len-1; i++) {
            int left = i, right = i+1;
            while(left >=0 && right < len){

                if (s.charAt(left) == s.charAt(right)) {
                    int curLen = right - left +1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        startPos = left;
                        endPos = right;
                    }
                } else {
                    break;
                }
                left--;
                right++;
            }
        }

        if (maxLen == 0) {
            return "";
        }

        return s.substring(startPos, endPos +1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println("result = " + LongestPalindromicSubstring.longestPalindrome(s));
    }
}
