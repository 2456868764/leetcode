package com.jun.study.leetcode.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/valid-anagram
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] charS = s.toLowerCase().toCharArray();
        char[] charT = t.toLowerCase().toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return Arrays.equals(charS, charT);

    }

    public boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            table.put(s.charAt(i), table.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            table.put(t.charAt(i), table.getOrDefault(t.charAt(i), 0) - 1);
            if (table.get(t.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        ValidAnagram validAnagram = new ValidAnagram();
        boolean isValid = validAnagram.isAnagramHashMap(s, t);
        System.out.println("valid:" + isValid);
    }


}
