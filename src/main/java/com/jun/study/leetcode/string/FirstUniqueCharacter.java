package com.jun.study.leetcode.string;

import java.util.HashMap;
import java.util.Map;


/**
 * easy  https://leetcode.cn/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        String s = "loveleetcode";
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        System.out.println("first index = " + firstUniqueCharacter.firstUniqChar(s));
    }

}
