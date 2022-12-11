package com.jun.study.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * medium
 * https://leetcode.com/problems/find-and-replace-in-string/
 */
public class FindAndReplaceInString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = sources.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int beginIndex = indices[i];
            String source = sources[i];
            int sublen = source.length();
            if (beginIndex + sublen > s.length()) {
                break;
            }
            String indexString = s.substring(beginIndex, beginIndex + sublen);
            if (source.equals(indexString)) {
                map.put(beginIndex, i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(i)) {
                builder.append(targets[map.get(i)]);
                i+=sources[map.get(i)].length()-1;
            } else {
                builder.append(s.charAt(i));
            }

        }

        return builder.toString();

    }


}
