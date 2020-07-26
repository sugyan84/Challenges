package com.app.testCodes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;


public class Demo5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Sugyan\\temp\\Challenges\\jsonFile.json")));
        String line = null;
        StringBuffer sbfr = new StringBuffer();

        while ((line = br.readLine()) != null) {
            sbfr.append(line);
        }

        Object read = JsonPath.read(sbfr.toString(), "$.firstElement[*].field1");

        if (read instanceof JSONArray) {
            JSONArray read1 = (JSONArray) read;
            List<String> list = new ArrayList<>();
            read1.forEach(v -> list.add((String) v));
            System.out.println("Arrays");
            
            list.forEach(v-> System.out.println("V: "+v));
            
        } else if (read instanceof String) {
            System.out.println("One string");
        }
    }
}
