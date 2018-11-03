package com.app.byju;

import java.util.*;


class TestClass {

    static long[] arr;
    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String args[]) throws Exception {


        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);

        long N = s.nextLong();

        arr = new long[(int) N];

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextLong();
        }



        System.out.println(map);

        long Q = s.nextLong();

        buildMap();

        for (int i = 0; i < Q; i++) {
            long a = s.nextLong();
            answerQuery(a);
        }

    }

    private static void buildMap() {
        Arrays.sort(arr);

        int index = 0;

        int noofCounter = 1;

        for (int counter = 1; counter <= arr[arr.length - 1]; counter++) {
            if (counter == 1) {
                map.put(counter, 0);
                continue;
            }

            if (arr[index + 1] < counter) {
                index++;
                noofCounter++;
                map.put(counter, noofCounter);
            } else {
                map.put(counter, noofCounter);
            }
        }
    }

    private static void answerQuery(long nextLong) {
        long value = 1 * arr.length;

        for (int i = 2; i <= arr[arr.length - 1]; i++) {

            long cantContributeCount = map.get(i);

            long additionalVal = arr.length - cantContributeCount;

            if ((value + additionalVal) >= nextLong) {
                System.out.println(i);
                return;
            } else
            {
                value= (value + additionalVal);
                continue;
            }

        }

        System.out.println(-1);

    }
}

