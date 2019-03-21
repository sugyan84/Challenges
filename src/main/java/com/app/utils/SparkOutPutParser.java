package com.app.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class SparkOutPutParser {

    public static void main(String[] args) throws IOException {
        
        String fileName = "C:\\Sugyan\\temp\\Challenges\\spark-output-2.txt";
        
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        
        String line = "";
        
        while((line = br.readLine())!=null){
            String substring = getStringBetween(line.trim(), '{', '}');
            String[] split = substring.split("\\,");

            for (int i = 0; i < split.length; i++) {
                System.out.print(split[i].split("\\=")[1]+"\t");
            }
            System.out.println();
        }
    }
    
    private static String getStringBetween(String inputString, char startChar, char endChar){
        StringBuffer sbStr = new StringBuffer();
        boolean recording = false;
        for (int i = 0; i < inputString.length(); i++) {
            if(inputString.charAt(i)==startChar){
                recording = true;
                continue;
            }
            if(inputString.charAt(i)==endChar){
                recording = false;
                break;
            }
            if(recording)
                sbStr.append(inputString.charAt(i));
        }
        return sbStr.toString();
    }
}
