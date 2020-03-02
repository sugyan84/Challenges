package com.app.testCodes;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Demo91892 {

    public static void main(String[] args) {

        JSONObject jObject = new JSONObject();

        jObject.put("EmployeeId", new Integer(121));
        jObject.put("Name", "Ramesh");
        jObject.put("Salary", new Double(15000.00));
        jObject.put("isPermanent", new Boolean(true));
        jObject.put("Nickname", null);

        //convert from JSONObject to JSON string
        String jsonText = jObject.toJSONString();

        System.out.println(jsonText);

        JSONParser parser = new JSONParser();

        //convert from JSON string to JSONObject
        JSONObject newJObject = null;
        try {
            newJObject = (JSONObject) parser.parse(jsonText);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(newJObject.get("EmployeeId"));
        System.out.println(newJObject.get("Name"));
        System.out.println(newJObject.get("Salary"));
        System.out.println(newJObject.get("isPermanent"));
        System.out.println(newJObject.get("Nickname"));
    }
}
