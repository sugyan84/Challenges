package com.app.algos.base62Encoding;

/**
 * This program shows the logic of base62 algorithm.
 */
public class Demo {

    public static void main(String[] args) {

        System.out.println(base62Encoder(2480));
    }

    private static String base62Encoder(int deci) {
        String defaultStr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuffer hashStr = new StringBuffer();

        while (deci > 0) {
            int index = deci % defaultStr.length();

            hashStr.append(defaultStr.charAt(index));

            deci/=62;
        }

        return hashStr.toString();
    }
}
