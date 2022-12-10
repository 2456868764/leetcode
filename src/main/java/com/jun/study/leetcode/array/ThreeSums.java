package com.jun.study.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/ 
 */
public class ThreeSums {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumResult = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        sumResult.add(result);
                    }
                }
            }
        }
        return sumResult;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (n < 3) {
            return result;
        }
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                continue;
            }
            int target = -nums[i];
            int left = i+1;
            int right = n-1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    // find
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }

            }

        }

        return result;

    }

    public List<List<Integer>> threeSum20928(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < len - 2; k++) {
            if (nums[k] > 0) {
                continue;
            }
            int left = k+1;
            int right = len-1;
            while (left < right) {
                if (nums[k] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[k], nums[left], nums[right]));
                } else if(nums[left] + nums[right] + nums[k] >0) {
                    right--;
                } else{
                    left++;
                }
            }

        }
        return result;


    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSums threeSums = new ThreeSums();
        List<List<Integer>> result = threeSums.threeSum2(nums);
        System.out.println("result=" + result);
    }
}
