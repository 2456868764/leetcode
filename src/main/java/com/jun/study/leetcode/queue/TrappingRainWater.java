package com.jun.study.leetcode.queue;

/**
 *  https://leetcode.cn/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int sum = 0;
        if (height.length <= 1) {
            return sum;
        }

        for (int i = 1; i < height.length; i++) {
            int left = 0, right = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > left) {
                    left = height[j];
                }
            }
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > right) {
                    right = height[j];
                }
            }
            if (left > height[i] && right > height[i]) {
                int min = left > right ? right : left;
                sum += min - height[i];
            }
        }
        return sum;
    }


    public int trap2(int[] height) {
        int sum = 0;
        if (height.length <= 1) {
            return sum;
        }
        int[] max_right = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }

        int maxLeft = height[0];
        int maxRight = 0;
        for (int i = 1; i < height.length-1; i++) {
            maxLeft = Math.max(maxLeft, height[i-1]);
            maxRight = max_right[i];
            if (maxLeft > height[i] && maxRight > height[i]) {
                int min = maxLeft > maxRight ? maxRight : maxLeft;
                sum += min - height[i];
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4, 2, 0, 3, 2, 5};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println("sum = " + trappingRainWater.trap2(height));

    }
}
