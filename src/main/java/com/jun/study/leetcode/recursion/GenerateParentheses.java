package com.jun.study.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, 3, "", result);
        return result;
    }

    private void generate(int left, int right, int n, String s, List<String> result) {
        // terminator
        if (left == n && left == right) {
            result.add(s);
            return;
        }
        // process
        String leftS = s + "(";
        String rightS = s + ")";
        //drill down
        if (left < n) {
            generate(left + 1, right, n, leftS, result);
        }
        if (left > right) {
            generate(left, right + 1, n, rightS, result);
        }
        //recover

    }


    private void generate0928(int left, int right, int n, String s, List<String> result) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            String ns = s + "(";
            generate0928(left + 1, right, n,  ns, result);
        }
        if (right < left && right < n) {
            String ns = s + ")";
            generate0928(left , right+1, n,  ns, result);
        }

    }


    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(6);
        System.out.println("result:" + result);

    }
}
