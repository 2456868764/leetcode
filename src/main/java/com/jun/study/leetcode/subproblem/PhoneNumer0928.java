package com.jun.study.leetcode.subproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumer0928 {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        Map<Character, String> phones = new HashMap<>();
        phones.put('2', "abc");
        phones.put('3', "def");
        phones.put('4', "ghi");
        phones.put('5', "jkl");
        phones.put('6', "mno");
        phones.put('7', "pqrs");
        phones.put('8', "tuv");
        phones.put('9', "wxyz");
        generatePhones(digits, 0, "", results, phones);
        return results;
    }

    private void generatePhones(String digits, int level, String str, List<String> results, Map<Character, String> phones) {
        if (level == digits.length()) {
            results.add(str);
            return;
        }
        char c = digits.charAt(level);
        String numStr = phones.get(c);
        for (int i = 0; i < numStr.length(); i++) {
            String nextStr = str + numStr.charAt(i);
            generatePhones(digits, level+1, nextStr, results, phones);
        }
    }
}
