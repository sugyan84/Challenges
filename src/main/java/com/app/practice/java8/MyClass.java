package com.app.practice.java8;

import java.util.List;


public class MyClass {

    List<String> list;

    String attr;

    public List<String> getList() {
        return list;
    }

    public void setList(final List<String> list) {
        this.list = list;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(final String attr) {
        this.attr = attr;
    }

    public MyClass getSameObject(){
        return this;
    }
}
