package com.jun.study.leetcode.google.day28;

public class TwoSumII {

    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {


            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                }
            }
        }

        return result;
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j=numbers.length -1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            }
            if (sum < target) {
                i++;
            }

            if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{-1, -1};

    }
}
