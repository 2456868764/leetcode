package com.jun.study.leetcode.string;

/**
 * easy : https://leetcode.cn/problems/longest-common-prefix
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        int index = -1;
        boolean stop = false;

        if (strs.length <= 1) {
            return strs[0];
        }

        for (int i = 0; i < strs[0].length(); i++) {

            for (int j = 1;  j < strs.length; j++) {

                if (i >=strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    stop = true;
                    break;
                }

            }
            if (stop) {
                break;
            }

            index++;

        }

        return index >= 0 ? strs[0].substring(0, index+1) : "";

    }

    public static void main(String[] args) {
        String[] ar = new String[]{"dog","racecar","car"};
        String[] ar2 = new String[]{"flower","flow","flight"};
        String[] ar3 = new String[]{"ab","a"};
        System.out.printf("longest common prefix string=:%s", longestCommonPrefix(ar3));
    }

}

