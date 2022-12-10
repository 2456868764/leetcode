package com.jun.study.leetcode.array;

/**
 *  https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MostWater {

    public int maxArea(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int area = (j - i) * Math.min(a[i], a[j]);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    public int maxArea2(int[] a) {
        int max = 0;
        for (int i = 0, j = a.length - 1; i < j; ) {
            int minHeight = (a[i] < a[j]) ? a[i++] : a[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }


    public int maxArea0928(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int area = (j - i) * Math.min(a[i], a[j]);
                max = Math.max(max, area);
            }
        }

        return max;

    }

    public int maxArea20928(int[] a) {
        int max = 0;
        for (int i = 0, j = a.length - 1; i < j; ) {
            int minHeight = a[i] < a[j] ? a[i++] : a[j--];
            int area = (j-i+1) * minHeight;
            max = Math.max(area, max);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 3, 8, 7};
        MostWater mostWater = new MostWater();
        int max = mostWater.maxArea2(a);
        System.out.println("most water:" + max);
        int i = 1;
        System.out.println("a[i]:" + a[++i]);
        System.out.println("i:" + i);
    }


}
