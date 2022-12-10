package com.jun.study.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *  https://leetcode.cn/problems/sort-characters-by-frequency/
 */

public class FrequencySort {

    public static String sort(String s) {
        Map<Character, Integer> stat = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            stat.put(s.charAt(i), stat.getOrDefault(s.charAt(i), 0) + 1);
        }
        Character[] chs = new Character[s.length()];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = new Character(s.charAt(i));
        }
        Arrays.sort(chs, new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2) {
                return stat.get(o2) - stat.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            sb.append(chs[i].charValue());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println("result = " + FrequencySort.sort(s));
    }

}
