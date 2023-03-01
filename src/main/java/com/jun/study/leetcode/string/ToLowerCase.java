package com.jun.study.leetcode.string;

/**
 * easy https://leetcode.cn/problems/to-lower-case/
 */
public class ToLowerCase {

    public String toLowerCase1(String s) {
        return s.toLowerCase();
    }

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch > 'A' && ch < 'Z') {
                ch += 32;
                sb.append(ch);
            }

        }
        return sb.toString();
    }

}
