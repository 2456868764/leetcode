package com.jun.study.leetcode.string;

/**
 * medium: https://leetcode.cn/problems/string-to-integer-atoi/
 */
public class StringToIntegerAtoi {

    public static int myAtoi(String s) {

        int index = 0, sign = 1, total = 0;

        if (s.length() == 0) {
            return 0;
        }

        while (s.charAt(index) == ' ' && index < s.length()) {
            index++;
        }

        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < s.length()) {
            char ch = s.charAt(index);
            int digit = ch - '0';
            if (digit < 0 || digit > 9) {
                break;
            }

            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;

            index++;

        }

        return total * sign;


    }

    public static void main(String[] args) {
        System.out.printf(" value = %d ", myAtoi("4193 with words"));
        System.out.printf(" value = %d ", myAtoi("   -42"));
    }

}
