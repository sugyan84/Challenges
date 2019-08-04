package com.app.testCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Demo3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        list.add("Sugyan");
        list.add("Sahu");
        list.add(null);
        list.add("Panigrahy");
        list.add(null);

        Map<Integer, String> collect = list.stream()
                .filter(l -> l!=null)
                .collect(Collectors.toMap(l -> l.length(), l -> l.toUpperCase()));

        //System.out.println(collect);

        List<Integer> integers = Arrays.asList(1, 5, 7, 9, 10, 15);
        List<Integer> reduced = integers.stream().collect(Collectors.toList());
        //System.out.println("Reduced: "+reduced);

        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(4);
        streamGenerated.forEach(System.out::println);

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        streamIterated.forEach(System.out::println);

        Stream<String> stringStream = Stream.of("abc", "def", "pqr", "xyz");
        List<String> collect1 = stringStream.map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect1);
    }
}
