package com.app.challenges.codeGaldiators;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class TestClass2 {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static InputType type;
    private static PrintStream out;

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }

    /**
     * @param pType:
     *         sc for Scanner
     *         br for BufferedReader
     */
    public static void initializeReaders(InputType pType) {

        if (pType.equals(InputType.BUFFERED_READER)) {
            type = pType;
            br = new BufferedReader(new InputStreamReader(System.in));
        } else if (pType.equals(InputType.SCANNER)) {
            type = pType;
            sc = new Scanner(System.in);
        }
        out = System.out;
    }

    public static void main(String[] args) throws Exception {

        initializeReaders(InputType.SCANNER);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            
            process(arr);
        }

    }
    
    private static void process(int[] arr){
        int[] listArr = new int[arr.length];
        int[] listArr2 = new int[arr.length];
        
        //start processing from Index-0
        int sum1 = processIndex(arr, 0, 0, 0, listArr);
        
        //start processing from Index-1
        int sum2 = processIndex(arr, 0, 0, 1, listArr2);

        System.out.println(Math.max(sum1, sum2));
    }
    
    private static int processIndex(int[] arr, int currSum, int currIndex, int i, int[] listArr){
        if(arr==null || i>= listArr.length || arr.length==0){
            return 0;
        }
        
        if(currIndex >= arr.length){
            return currSum;
        }
        
        //consider currIndex element
        listArr[i] = arr[currIndex];
        int sum1 = processIndex(arr, currSum + arr[currIndex], currIndex + 2, i + 1, listArr);

        //don't consider currIndex element
        int sum2 = processIndex(arr, currSum, currIndex + 2, i, listArr);
        
        return Math.max(sum1, sum2);
    }
}

