package com.app.practice.java8;

import java.util.ArrayList;
import java.util.List;


public class TestContainsString {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        list.add("Sugyan");
        list.add("Sahu");
        list.add("other");

        System.out.println(list.stream().anyMatch("SAHU"::equalsIgnoreCase));
    }
}
