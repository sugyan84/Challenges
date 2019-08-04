package com.app.testCodes;

import java.util.ArrayList;
import java.util.List;


public class TT {

    public static void main(String[] args) {
        List<String> idiOnlineBNAs = new ArrayList<>();
        idiOnlineBNAs.add("Sugyan");
        idiOnlineBNAs.add("Sahu");

        StringBuffer data1 = new StringBuffer();
        idiOnlineBNAs.stream().filter(rbo -> rbo != null)
                .forEach(rbo -> data1.append(rbo.length() + ", "));
        System.out.println(data1.toString());
    }
}
