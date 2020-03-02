package com.app.testCodes;

/**
 * ABCDEFGH
 * int: 2
 * GHEFCDAB
 */
public class PairSwappingOfChars {

    public static void main(String[] args) {
        String string = "ABCDEFGH";
        int swapSet = 3;

        System.out.println("getSwappedString() = " + getSwappedString(string, swapSet));
    }

    private static String getSwappedString(final String string, int x) {
        char[] chars = string.toCharArray();

        for (int i = 0, j = chars.length - x; i < j; i++, j = (chars.length - (2 * x))) {
            int k = 0;
            while (k < x) {
                char tempChar = chars[i];
                chars[i] = chars[j];
                chars[j] = tempChar;
                if (!(k == x - 1)) {
                    i++;
                    j++;
                }
                k++;
            }
        }
        return String.valueOf(chars);
    }
}
