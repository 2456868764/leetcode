package com.jun.study.leetcode.sort;

public class BubbleSort {
    public void sort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1-i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 4, 8, 2, 8, 9, 10, 20, 4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[" + i + "]=" + nums[i]);
        }
    }
}
