package com.app.testCodes;

import java.util.ArrayList;
import java.util.List;


public class Demo990 {

    public static void main(String[] args) {
        method1(null);

        List<Object> list = new ArrayList<>();
        
        list.add(new String("123"));
        list.add(new Integer(3));
        list.add(new Demo());
    }
    
    static void method1(Object o){
        System.out.println("Object");
    }

    static void method1(String o){
        System.out.println("String");
    }
}
