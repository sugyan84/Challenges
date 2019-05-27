package com.app.challenges.vimeo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class TestClass {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static InputType type;
    private static PrintStream out;

    private enum InputType {
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

        long T = sc.nextLong();

        for (int i = 0; i < T; i++) {
            long N = sc.nextLong();
            long u = sc.nextLong();
            long v = sc.nextLong();
            
            if( u > v){
                //keep adding till you reach.
                long currNum = v;
                long targetNum = u;
                long totalTime = 0;
                int looper = 0;
                long tillNowMultiple = 1;
                boolean status = false;
                while(currNum < targetNum){
                    looper++;
                    tillNowMultiple = tillNowMultiple * 3;
                    currNum = currNum + tillNowMultiple;
                    if(currNum==targetNum){
                        System.out.println((looper*(looper+1))/2);
                        status = true;
                        break;
                    }
                }

                if (!status) {
                    System.out.println(-1);
                }
            }else if(u < v){
                //keep subtracting till u reach.
                long currNum = v;
                long targetNum = u;
                long totalTime = 0;
                int looper = 0;
                long tillNowMultiple = 1;
                boolean status = false;
                while(currNum > targetNum){
                    looper++;
                    tillNowMultiple = tillNowMultiple * 3;
                    currNum = currNum - tillNowMultiple;
                    if(currNum==targetNum){
                        System.out.println((looper*(looper+1))/2);
                        status = true;
                        break;
                    }
                }

                if (!status) {
                    System.out.println(-1);
                }
            }
        }

    }
}

