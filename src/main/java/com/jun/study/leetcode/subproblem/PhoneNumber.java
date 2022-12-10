package com.jun.study.leetcode.subproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, String> phones = new HashMap<>();
        phones.put('2', "abc");
        phones.put('3', "def");
        phones.put('4', "ghi");
        phones.put('5', "jkl");
        phones.put('6', "mno");
        phones.put('7', "pqrs");
        phones.put('8', "tuv");
        phones.put('9', "wxyz");

        generateList(digits, 0, "", result, phones);
        return result;
    }

    private void generateList(String digits, int i, String genString, List<String> result, Map<Character, String> phones) {
        //terminator
        if (i == digits.length()) {
            result.add(genString);
            return;
        }

        //process data
        String phoneLetter = phones.get(digits.charAt(i));

        //drill down to sub problem or next level
        for (int j = 0; j < phoneLetter.length(); j++) {
            generateList(digits, i + 1, genString + phoneLetter.charAt(j), result, phones);
        }

        //merge

        //reverse

    }

    public static void main(String[] args) {
        String digits = "23";
        PhoneNumber phoneNumber = new PhoneNumber();
        System.out.println("result:" + phoneNumber.letterCombinations(digits));
    }


}
