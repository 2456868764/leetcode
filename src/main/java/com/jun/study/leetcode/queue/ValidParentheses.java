package com.jun.study.leetcode.queue;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.pop().equals(pairs.get(ch))) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s = "()[]{}";
        ValidParentheses validParentheses = new ValidParentheses();
        boolean isValid = validParentheses.isValid(s);
        System.out.println("isValid:" + String.valueOf(isValid));
    }
}
