package com.jun.study.leetcode.string;

import java.util.*;

public class GroupAnagrams {

    // 时间复杂度 n * log(n)
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            List<String> list = resultMap.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            resultMap.put(key,list);
        }

        return new ArrayList<>(resultMap.values());

    }

    // 时间复杂度 n ^ 2
    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            boolean found = false;
            for (int j = 0; j < results.size(); j++) {
                List<String> list = results.get(j);
                String resultWorld = list.get(0);
                if (isAnagram(word, resultWorld)) {
                    list.add(word);
                    found = true;
                }

            }
            if (!found) {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                results.add(newList);
            }
        }

        return results;
    }

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

    public static void main(String[] args) {
        String[] words = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(words));
    }
}
