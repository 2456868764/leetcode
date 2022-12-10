package com.jun.study.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {
    Deque<Integer> data = new ArrayDeque<>();
    Deque<Integer> helper = new ArrayDeque<>();
    public MinStack() {
    }
    public void push(int val) {
        data.push(val);
        if (helper.isEmpty()) {
            helper.push(val);
        }else {
            if (helper.peek() > val) {
                helper.push(val);
            } else {
                helper.push(helper.peek());
            }
        }
    }

    public void pop() {
        data.pop();
        helper.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return helper.peek();
    }

    public static void main(String[] args) {

    }
}
