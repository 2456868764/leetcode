package com.jun.study.leetcode.google.day27;

import java.util.HashMap;
import java.util.Map;

/**
 * easy https://leetcode.com/problems/two-sum/
 */
public class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i]) && maps.get(target-nums[i]) != i) {
                result[0] = i;
                result[1] = maps.get(target - nums[i]);
            }
        }
        return result;
    }
}
