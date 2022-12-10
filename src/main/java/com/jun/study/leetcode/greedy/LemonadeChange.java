package com.jun.study.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/lemonade-change/description/
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five  =0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five ++;
            } else if (bills[i] == 10) {
                if (five < 0) {
                    return false;
                }

                five --;
                ten ++;

            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -=3;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 10, 20};
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println("reuslt:" + lemonadeChange.lemonadeChange(bills));
    }
}
