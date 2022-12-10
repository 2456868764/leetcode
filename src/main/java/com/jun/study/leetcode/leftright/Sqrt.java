package com.jun.study.leetcode.leftright;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Sqrt {
    public int find(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (mid * mid > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        int result = sqrt.find(10);
        System.out.println("result = " + result);
    }
}
