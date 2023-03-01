package com.jun.study.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * easy https://leetcode.cn/problems/jewels-and-stones/
 */
public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> mapJewels = new HashMap();
        for (int i = 0; i < jewels.length(); i++) {
            mapJewels.put(jewels.charAt(i), mapJewels.getOrDefault(jewels.charAt(i), 0) + 1);
        }
        int sum = 0;

        for (int j = 0; j < stones.length(); j++) {
            if (mapJewels.get(stones.charAt(j)) != null) {
                sum ++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        //String jewels = "aA", stones = "aAAbbbb";
        String jewels = "z", stones = "ZZ";
        System.out.println("total jewels = " + numJewelsInStones(jewels, stones));
    }
}
