package com.jun.study.leetcode.string;

/**
 * easy： https://leetcode.cn/problems/valid-palindrome-ii/
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int left=0, right=s.length()-1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right);
            }

        }
        return true;
    }

    private boolean validPalindrome(String s, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
