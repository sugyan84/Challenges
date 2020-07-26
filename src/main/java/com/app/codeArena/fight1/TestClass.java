package com.app.codeArena.fight1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;


public class TestClass {

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

        /*Box b1 = new Box("101");
        Box b2 = new Box("111");

        b1.processWithRemovedIndex(1);
        b2.processWithRemovedIndex(1);

        System.out.println(b1.equals(b2));*/


        initializeReaders(InputType.SCANNER);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Box> originalList = new ArrayList<Box>(n);

            for (int noOfLines = 0; noOfLines < n; noOfLines++) {
                String binaryStr = sc.next();
                originalList.add(new Box(binaryStr));
            }

            System.out.println("Original no. of Boxes list: "+originalList.size());

            for (int tryCol = 0; tryCol < m; tryCol++) {
                Set<Box> checkSet = new HashSet<Box>();

                for (int boxList = 0; boxList < originalList.size() ; boxList++) {
                    Box boxUnderTest = originalList.get(boxList);
                    boxUnderTest.processWithRemovedIndex(tryCol);
                    checkSet.add(boxUnderTest);
                }

                if(checkSet.size()==n){
                    System.out.println("Yes");
                    break;
                }else if(checkSet.size()!=n && tryCol==m-1){
                    System.out.println("No");
                }

            }
        }

    }
}

class Box {
    String binaryString;

    StringBuffer buffer;

    String tempString;

    Box(final String binaryString) {
        this.binaryString = binaryString;
        buffer = new StringBuffer(binaryString);
    }

    String getBinaryString() {
        return binaryString;
    }

    void setBinaryString(final String binaryString) {
        this.binaryString = binaryString;
    }

    @Override public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Box box = (Box) o;
        return Objects.equals(tempString, box.tempString);
    }

    @Override public int hashCode() {

        return Objects.hash(tempString);
    }

    public void processWithRemovedIndex(int index) {
        this.buffer.deleteCharAt(index);
        tempString = buffer.toString();
        this.buffer = new StringBuffer(binaryString);
    }
}
