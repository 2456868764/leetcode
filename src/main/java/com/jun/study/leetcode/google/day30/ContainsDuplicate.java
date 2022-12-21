package com.jun.study.leetcode.google.day30;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = maps.getOrDefault(nums[i], 0);
            if (count > 0) {
                return true;
            }
            maps.put(nums[i], count + 1);
        }
        return false;

    }

}
