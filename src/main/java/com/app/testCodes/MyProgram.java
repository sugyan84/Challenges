package com.app.testCodes;

import java.io.FileOutputStream;
import java.io.IOException;


public class MyProgram {
    public static void main(String args[]) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("test.txt");
            out.write(122);
        } catch (IOException io) {
            System.out.println("IO Error.");
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
