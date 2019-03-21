package com.app.testCodes;

public class Demo2 {

    public static void main(String[] args) {
        System.out.println(getValue());
    }

    private static String getValue() {
        String val = null;
        try {
            
            if(val==null){
                return "Null Hai";
            }
        }catch (Exception e){
            System.out.println("Exception block");
            
        }finally {
            System.out.println("Finally block");
        }
        
        return val;
    }
}
