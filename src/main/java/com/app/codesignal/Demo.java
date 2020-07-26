package com.app.codesignal;

import java.util.HashSet;
import java.util.Set;


public class Demo {

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingCharacter("bcccccccccccccyb"));
    }

    static char firstNotRepeatingCharacter(String s) {
        char[] array = s.toCharArray();
        Set<Character> seen = new HashSet();

        int minIndex = Integer.MAX_VALUE;
        char ansChar = '_';

        for (int i = (array.length - 1); i >= 0; i--) {
            if (!seen.contains(array[i])) {
                //Not repeating
                seen.add(array[i]);
                ansChar = array[i];
                minIndex = i;
            } else if (ansChar == array[i]) {
                ansChar = '_';
            }
        }

        String[][] arr = new String[3][4];

        System.out.println(arr[0].length);

        return ansChar;
    }

}
