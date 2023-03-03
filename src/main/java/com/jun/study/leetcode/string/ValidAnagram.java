package com.jun.study.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * easy: https://leetcode.cn/problems/valid-anagram/
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Map.Entry<Character, Integer> item : countMap.entrySet()) {
            if (item.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)  {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

}
