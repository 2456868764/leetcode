package com.jun.study.leetcode.string;

import com.google.common.base.Strings;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        if (s.length() <= 1) {
            return true;
        }

        int left = 0, right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right &&  !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (right < 0 || left >= s.length()) {
                return false;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;

        }

        return true;

    }


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = ".,";
        System.out.println(isPalindrome(s1));
    }
}
