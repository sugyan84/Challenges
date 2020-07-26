package com.app.testCodes;

import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class Base64Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String text = "Java8 base64 encoding-decoding.";

        String encodedStr = Base64.getEncoder().encodeToString(text.getBytes("UTF-8"));

        System.out.println(encodedStr);

        byte[] decode = Base64.getDecoder().decode(encodedStr);

        for (int i = 0; i < decode.length; i++) {
            System.out.println(decode[i]);
        }

        String s = new String(decode, "UTF-8");

        System.out.println("s = " + s);
    }
}
