package com.app.practice.string;

import java.util.LinkedList;
import java.util.List;


public class CustomSplitMethod {

    public static void main(String[] args) {
        String[] trv = splitStringBasedOn("The sky is blue", 'e');

        for (int i = 0; i < trv.length; i++) {
            System.out.println(trv[i]);
        }
    }
    
    public static String[] splitStringBasedOn(String s, char splitChar){
        List<String> list = new LinkedList<>();
        boolean isStarting = true;
        StringBuffer sbfr = null;
        
        for(char now : s.toCharArray()){
            if(isStarting){
                isStarting = false;
                sbfr = new StringBuffer();
            }
            if(now!=splitChar){
                sbfr.append(now);
            }else {
                list.add(sbfr.toString());
                isStarting = true;
            }
        }
        list.add(sbfr.toString());
        
        String[] sArr = new String[list.size()];
        return list.toArray(sArr);
    }
}
