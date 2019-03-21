package com.app.algos.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PermutationOfString {
    
    private static final String inputStr = "ABCDEFGHIJ";

    public static void main(String[] args) {

        List<String> permute = permute(inputStr);
        System.out.println(permute);
        System.out.println(permute.size());
    }

    private static List<String> permute(final String inputStr) {
        if(inputStr==null || inputStr.length()==1)
            return Arrays.asList(inputStr);
        
        char charToAppend;
        List<String> listToReturn = new ArrayList<>();
        
        if(inputStr.length()>1){
            charToAppend = inputStr.charAt(0);
            
            List<String> partialPermutes = permute(inputStr.substring(1));
            
            partialPermutes.stream().forEach(p -> {
                for (int i = 0; i <= p.length(); i++) {
                    StringBuffer sbfr = new StringBuffer(p);
                    listToReturn.add(sbfr.insert(i, charToAppend).toString());
                }
            });
            
            return listToReturn;
        }
        
        return null;
    }
}
