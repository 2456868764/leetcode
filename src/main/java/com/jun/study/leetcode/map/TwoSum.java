package com.jun.study.leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = table.get(target-nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, 9);
        System.out.println("result:" + result[0] + "," + result[1]);
    }
}
