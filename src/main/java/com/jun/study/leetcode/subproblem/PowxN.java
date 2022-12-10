package com.jun.study.leetcode.subproblem;

/**
 * https://leetcode.cn/problems/powx-n/
 */
public class PowxN {
    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        return powRecursion(x, n);
    }

    private double powRecursion(double x, int n) {
        //terminator
        if (n == 0) {
            return 1;
        }
        //process

        //split sub problem or drill down
        double subResult = powRecursion(x, n / 2);

        // merge
        if (n % 2 == 0) {
            return subResult * subResult;
        } else{
            return subResult * subResult * x;
        }

        //reverse state
    }

    public static void main(String[] args) {
        PowxN powxN = new PowxN();
        System.out.println("power(2,10)=" + powxN.myPow(2,10));
    }
}
