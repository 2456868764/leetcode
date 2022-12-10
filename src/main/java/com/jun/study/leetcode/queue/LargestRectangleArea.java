package com.jun.study.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int left = i;
            while (left > 0 && heights[left - 1] >= height) {
                left--;
            }
            int right = i;
            while (right < n - 1 && heights[right + 1] >= height) {
                right++;
            }
            int width = right - left + 1;
            int area = width * height;
            if (area > max) {
                max = area;
            }
        }
        return max;

    }

    public int largestRectangleAreaByStack(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.pollLast() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {

        }
        return 0;
    }

    public int largestRectangleAreaByStackGard(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>(len);
        stack.addLast(0);
        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int currHeight = heights[stack.pollLast()];
                int currWidth = i-stack.peekLast() -1;
                res = Math.max(res, currHeight * currWidth);
            }
            stack.addLast(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int area = largestRectangleArea.largestRectangleAreaByStackGard(heights);
        System.out.println("max area:" + area);
    }
}
