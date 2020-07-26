package com.app.practice.leetcode._220;

/**
 * This program implements pow(x,n)
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(power(3, 4));

        while (true) {
            System.out.println();
        }
    }

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double v = power(x, n / 2);

        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }

    }
}
