package com.jun.study.leetcode.sort;

public class QuickSort {
    public void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(nums, begin, end);
        quickSort(nums, begin, pivot-1);
        quickSort(nums,pivot+1, end);
    }

    private int partition(int[] nums, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                int tmp = nums[counter];
                nums[counter] = nums[i];
                nums[i] = tmp;
                counter++;
            }
        }
        int temp = nums[pivot];
        nums[pivot] = nums[counter];
        nums[counter] = temp;
        return counter;
    }
}
