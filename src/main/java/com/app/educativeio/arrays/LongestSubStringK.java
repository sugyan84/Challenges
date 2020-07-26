package com.app.educativeio.arrays;

import java.util.HashMap;
import java.util.Map;


public class LongestSubStringK {

    public static void main(String[] args) {
        System.out.println("findLength(\"cbbebi\", 3) = " + findLength("araaci", 2));
    }

    public static int findLength(String str, int k) {
        // TODO: Write your code here
        int len = 0;
        int maxLen = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();

        char[] arr = str.toCharArray();
        for (; end < arr.length; end++) {
            /*len++;
            maxLen = Math.max(len, maxLen);*/
            map.computeIfPresent(arr[end], (key, OldVal) -> OldVal + 1);
            map.computeIfAbsent(arr[end], (key) -> 1);

            while (map.size() > k) {
                Integer integer = map.get(arr[start]);
                int newVal = integer - 1;
                if (newVal == 0) {
                    map.remove(arr[start]);
                } else {
                    map.put(arr[start], newVal);
                }
                start++;
                len--;
                maxLen = Math.max(end-start+1, maxLen);
            }
        }
        return maxLen;
    }
}
