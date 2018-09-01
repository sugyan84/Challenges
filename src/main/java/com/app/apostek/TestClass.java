package com.app.apostek;

import java.util.Scanner;


class TestClass {
    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int Q = s.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = 0; i < Q; i++) {
            int queryType = s.nextInt();
            int index = s.nextInt();

            switch (queryType) {
                case 0:
                    process(arr, index);
                    break;

                case 1:
                    if (index >= 0 && index < N) {
                        arr[index] = 1;
                    }
                    break;

                default:
                    System.out.println("Invalid query Type!");
            }
        }

    }

    private static void process(int[] arr, int index) {
        boolean goLeft = true;
        boolean goRight = true;

        int currLeft = index;
        int currRight = index;

        int leftElement = -1;
        int rightElement = -1;

        while (goLeft || goRight) {
            if (goLeft) {
                currLeft--;

                if (currLeft >= 0 && arr[currLeft] == 1) {
                    leftElement = currLeft;
                    goLeft = false;
                }
            }

            if (goRight) {
                currRight++;

                if (currRight < arr.length && arr[currRight] == 1) {
                    rightElement = currRight;
                    goRight = false;
                }
            }
        }

        System.out.println(leftElement+" "+rightElement);
    }
}

