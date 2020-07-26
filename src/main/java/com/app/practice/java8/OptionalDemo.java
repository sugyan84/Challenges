package com.app.practice.java8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;


public class OptionalDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Str1", "Val1");
        map.put("Str2","Val2");
        map.put("Str3","Val3");


        StringBuffer sbfr = new StringBuffer();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            sbfr.append(next.getKey()+"="+next.getValue()+"|");
        }
        if (sbfr.length() > 1)
            sbfr.deleteCharAt(sbfr.length() - 1);

        System.out.println(sbfr);

        System.out.println(
                map.entrySet().stream().map(x -> x.getKey() + "=" + x.getValue()).collect(Collectors.joining("|")));
        /*StringBuffer sbfr = new StringBuffer();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            sbfr.append(iterator.next()+"|");
        }
        sbfr.deleteCharAt(sbfr.length()-1);
        System.out.println("Using 1.7   "+sbfr.toString());
        System.out.println(map.keySet().stream().collect(Collectors.joining("|")));*/

        //System.out.println(map.entrySet().stream().map(x -> x.getKey() + "=" + x.getValue()).collect(Collectors
        // .joining("|")));
    }
}
