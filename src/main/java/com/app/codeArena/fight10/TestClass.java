package com.app.codeArena.fight10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class TestClass {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static InputType type;
    private static PrintStream out;

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

        initializeReaders(InputType.BUFFERED_READER);

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            int N = Integer.parseInt(line.split(" ")[0]);
            int M = Integer.parseInt(line.split(" ")[1]);

            char[][] box = new char[N][M];

            for (int r = 0; r < N; r++) {
                String charLine = br.readLine();
                String[] eachChar = charLine.split(" ");
                for (int c = 0; c < M; c++) {
                    box[r][c] = eachChar[c].charAt(0);
                }
            }

            System.out.println(solution(N, M, box));
        }

    }

    private static int solution(int N, int M, final char[][] box) {

        int count = 0;
        for (int r = 0; r < N; r = r + 2) {
            for (int c = 0; c < M; c = c + 2) {
                if (isDiamond(r, c, box)) {
                    count++;
                }
            }
        }
        return count;

    }

    public static boolean isDiamond(int r, int c, char[][] box) {
        if (box[r][c] == '/') {
            c++;
            if (box[r][c] == '\\') {
                r++;
                if (box[r][c] == '/') {
                    c--;
                    if (box[r][c] == '\\') {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

