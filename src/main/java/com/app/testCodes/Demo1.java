package com.app.testCodes;

public class Demo1 {

    public static void main(String[] args) {
        BaseBox baseBox = new ChildBox();
        //System.out.println(baseBox.getX());

        int sizeOfArray = 3;
        int num = 4;

        new Demo1().customeMethod();
        System.out.println(num % sizeOfArray);

    }

    public void customeMethod() {
        int b = 30 + Object.class.getModifiers();
        System.out.println("Method= |" + new Throwable()
                .getStackTrace()[0]
                .getMethodName());
    }
}
