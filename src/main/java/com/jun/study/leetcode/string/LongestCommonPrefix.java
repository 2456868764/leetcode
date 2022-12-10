package com.jun.study.leetcode.string;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int prefix = -1;
        boolean stop = false;

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (ch != strs[j].charAt(i)) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
            prefix++;

        }
        return prefix >= 0 ? strs[0].substring(0, prefix) : "";
    }
}

