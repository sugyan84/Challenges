package com.app.datastructure.ds1;

public class Demo {

    public static void main(String[] args) {
        CustomDS ds = new CustomDS();

        ds.addElement(4);
        ds.addElement(4);
        ds.addElement(3);
        ds.addElement(3);
        ds.addElement(3);
        ds.addElement(3);
        ds.addElement(5);
        ds.addElement(5);
        ds.addElement(6);

        System.out.println("Less than 1: "+ds.getSumWithFrequency(1));

        System.out.println("Less than 3: "+ds.getSumWithFrequency(3));
    }
}
