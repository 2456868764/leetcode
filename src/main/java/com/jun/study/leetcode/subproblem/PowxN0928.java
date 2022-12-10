package com.jun.study.leetcode.subproblem;

public class PowxN0928 {
    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        return pow(x, n);

    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double sub = pow(x, n / 2);
        if (n % 2 == 0) {
            return sub * sub;
        }else {
            return sub * sub * x;
        }

    }
}
