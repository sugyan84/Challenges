package com.app.testCodes;

public class CurrentMethodName {

    public static void main(String[] args) {
        someMethod();
    }

    public static void someMethod() {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName());
    }
}
