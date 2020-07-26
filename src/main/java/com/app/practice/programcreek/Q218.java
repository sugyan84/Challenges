package com.app.practice.programcreek;

/**
 * Reverse an Integer
 * input: 123
 * output: 321
 */
public class Q218 {

    public static void main(String[] args) {
        System.out.println("reverseInteger() = " + reverseInteger(123));
    }

    private static int reverseInteger(int x) {
        if (x == 0) {
            return 0;
        }

        int revInteger = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            x = x / 10;

            revInteger = (revInteger * 10) + lastDigit;
        }

        return revInteger;
    }
}
