package com.app.testCodes;

import java.util.stream.IntStream;


public class TestMainForList {

    public static void main(String[] args) {
        IntStream chars = "hackerearth".chars();

        chars.distinct().peek(n -> System.out.println(n));

    }
}
