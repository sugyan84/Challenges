package com.app.practice.programcreek;

import com.app.utils.RecursionVisualizer;


/**
 * Implement power(x,n)
 */
public class Q220 {

    private static RecursionVisualizer recursionVisualizer = new RecursionVisualizer();

    public static void main(String[] args) {
        System.out.println("findPower(6, 3) = " + findPower(6, 3));
    }

    private static double findPower(double x, double n) {
        if (n < 0) {
            return 1 / pow(x, -n);
        } else {
            return pow(x, n);
        }
    }

    private static double pow(final double x, final double n) {

        recursionVisualizer.logMethodEntry(String.valueOf(x), String.valueOf(n));

        if (n == 0 || n < 0) {
            recursionVisualizer.logMethodExit(String.valueOf(1));
            return 1;
        }

        double v = pow(x, n / 2);
        double r = -1;
        if (n % 2 == 0) { //even
            r = v * v;
            recursionVisualizer.logMethodExit(String.valueOf(r));
            return r;
        } else {
            r = v * v * x;
            recursionVisualizer.logMethodExit(String.valueOf(r));
            return r;
        }
    }
}
