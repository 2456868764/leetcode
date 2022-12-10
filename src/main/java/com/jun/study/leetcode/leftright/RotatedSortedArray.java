package com.jun.study.leetcode.leftright;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */
public class RotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right =  nums.length -1;
        return searchIndex(nums, target, left, right);
    }

    private int searchIndex(int[] nums, int target, int left, int right) {
        int mid = (left+right)/2;
        if (nums[left] == target) {
            return left;
        }

        if (nums[right] == target) {
            return right;
        }

        if (nums[mid] == target) {
            return mid;
        }

        if (left == right) {
            return -1;
        }

        if (nums[left] <= nums[mid] && nums[mid] > target && nums[left] < target) {
            return searchIndex(nums, target, left, mid);
        } else if (nums[mid] < nums[right] && nums[mid] < target && nums[right] > target) {
            return searchIndex(nums, target, mid+1, right);
        } else {
            int re = searchIndex(nums, target, left, mid);
            if (re == -1){
                return searchIndex(nums, target, mid+1, right);
            }else{
                return re;
            }
        }


    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 9;
        RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();
        System.out.println("result = " + rotatedSortedArray.search(nums, target));


    }


}
