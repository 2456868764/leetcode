package com.jun.study.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pLen = p.length();
        char[] pchs = p.toCharArray();
        Arrays.sort(pchs);
        String newP = new String(pchs);

        for (int i = 0; i < s.length(); i++) {
            int endIndex = i + pLen > s.length() ? s.length() : i + pLen;
            char[] schs = s.substring(i, endIndex).toCharArray();
            Arrays.sort(schs);
            String newS = new String(schs);
            if (newP.equals(newS)) {
                result.add(i);
            }
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
