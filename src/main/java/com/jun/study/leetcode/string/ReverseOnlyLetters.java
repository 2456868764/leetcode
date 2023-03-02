package com.jun.study.leetcode.string;

/**
 * easy: https://leetcode.cn/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {
        char[] chs = s.toCharArray();

        for (int i = 0, j = chs.length - 1; i < j; ) {

            while ( i < j && !(chs[i] >= 'A' && chs[i] <= 'Z' || chs[i] >= 'a' && chs[i] <= 'z') ) {
                i++;
            }


            while (i < j && !(chs[j] >= 'A' && chs[j] <= 'Z' || chs[j] >= 'a' && chs[j] <= 'z') ) {
                j--;
            }

            // swap
            if (i >= j) {
                break;
            }

            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }

        return new String(chs);
    }

    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        String s1 = "ab-cd";
        String s2 = "7_28]";
        String s3 = "tNH95P=TV";
        System.out.println(reverseOnlyLetters(s3));
    }
}
