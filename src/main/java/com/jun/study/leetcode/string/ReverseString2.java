package com.jun.study.leetcode.string;

/**
 * easy : https://leetcode.cn/problems/reverse-string-ii/
 */
public class ReverseString2 {

    public static String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2*k) {

            int p = i+k-1;

            if (i +  k > s.length()) {
                if (s.length() - i < k) {
                    p = s.length()-1;
                }
            }

            for (int j = i; j < p; j++, p--) {
                char ch = chs[j];
                chs[j] = chs[p];
                chs[p] = ch;
            }
        }

        return new String(chs);

    }

    public static void main(String[] args) {
        String a = "abcdefg";
        int k =2;
        String a1 = "abcd";
        System.out.println("reverse string=" + reverseStr(a1, k));
    }


}
