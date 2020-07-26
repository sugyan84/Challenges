package com.app.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamDebuggerDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList(null, "Hello Sugyan", "Hi Punit", "Namaste London", "Home are you", "Hi",
                "Welcome");

        list.stream().filter(l -> l != null)
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .collect(Collectors.toList());
    }
}
