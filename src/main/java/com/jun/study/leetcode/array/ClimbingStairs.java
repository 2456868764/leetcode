package com.jun.study.leetcode.array;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    public int climbingStairs(int n) {
        if (n < 3) {
            return n;
        }
        return climbingStairs(n-1) + climbingStairs(n-2);
    }

//    public int climbingStairs2(int n) {
//        int[] temp = new int[n+1];
//        temp[0] = 1;
//        temp[1] = 2;
//        temp[2] = 3;
//        for (int i = 3; i <= n; i++) {
//            temp[i] = temp[i - 2] + temp[i - 1];
//            temp[i-2] = temp[i-1];
//            temp[i-1] = temp[i];
//        }
//        for (int i = 0; i < temp.length; i++) {
//            System.out.println("temp["+i+"]" + "=" + temp[i]);
//        }
//        return temp[n];
//    }

    public int climbingStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int step = climbingStairs.climbingStairs3(10);
        System.out.println("step:" + step);
    }

}
