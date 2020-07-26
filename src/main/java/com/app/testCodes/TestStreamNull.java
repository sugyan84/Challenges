package com.app.testCodes;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class TestStreamNull {

    public static void main(String[] args) {
        List<String> list = null;

        /*list.add("Sugyan");
        list.add("Sahu");*/

        Set<Integer> collect = Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(i -> i.length())
                .collect(Collectors.toSet());

        System.out.println(collect);
    }
}
