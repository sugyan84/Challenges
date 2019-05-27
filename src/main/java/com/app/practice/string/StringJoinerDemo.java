package com.app.practice.string;

import java.util.StringJoiner;


public class StringJoinerDemo {

    public static void main(String[] args) {
        String[] arr = {"abc", "pqr", "xyz", "mno"};
        
        StringJoiner joiner = new StringJoiner(":", "$", ".");
        
        for(String s: arr){
            joiner.add(s);
        }

        System.out.println(joiner);
    }
}
