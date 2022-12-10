package com.jun.study.leetcode.map;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> table = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = table.getOrDefault(key, new ArrayList<>());
            list.add(str);
            table.put(key, list);
        }
        return new ArrayList<>(table.values());
    }

    public List<List<String>> groupAnagrams0928(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            List<String> values = map.getOrDefault(key, new ArrayList<>());
            values.add(strs[i]);
            map.put(key, values);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> values = groupAnagrams.groupAnagrams0928(str);
        System.out.println("values:" + values);

    }
}
