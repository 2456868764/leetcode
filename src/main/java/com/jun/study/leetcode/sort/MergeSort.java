package com.jun.study.leetcode.sort;

public class MergeSort {
    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i= left, j=mid+1, k=0;
        while (i <= mid && j <= right) {
            tmp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        System.arraycopy(tmp, 0, nums, left, tmp.length);
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 8, 2, 8, 9, 10, 20, 4};
        MergeSort bubbleSort = new MergeSort();
        bubbleSort.mergeSort(nums,0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[" + i + "]=" + nums[i]);
        }
    }
}
