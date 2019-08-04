package com.app.testCodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DuplicateKey {

    public static void main(String[] args) {

        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting("CO", "BNA-1"));
        list.add(new Hosting("CR", "BNA-14"));
        list.add(new Hosting("MX", "BNA-113"));
        list.add(new Hosting("CO", "BNA-1332"));
        list.add(new Hosting("CR", "BNA-156"));
        list.add(new Hosting("MX", "BNA-15"));
        list.add(new Hosting("MX", "BNA-197"));

        Map<String, String> map = new HashMap<>();
        // key = name, value - websites , but the key 'linode' is duplicated!?
        /*list.stream().collect(
                Collectors.groupingBy(bna -> bna.getBnaType())).entrySet().stream().forEach(kv -> {
            String finalStr = kv.getValue().stream().map(cc -> cc.getBnaId()).collect(Collectors.joining("|"));
            map.put(kv.getKey(), finalStr);
        });*/

        StringBuffer stringBuffer = new StringBuffer();
        list.stream().filter(bna -> bna != null).collect(
                Collectors.groupingBy(bna -> bna.getBnaType(),
                        Collectors.mapping(bna -> bna.getBnaId(), Collectors.joining("|"))))
                .entrySet().stream().forEach(kv -> {
            stringBuffer.append(kv.getKey() + "=" + kv.getValue() + "\n");
        });

        System.out.println("stringBuffer = " + stringBuffer);

    }
}
