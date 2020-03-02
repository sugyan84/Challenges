package com.app.testCodes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Demo {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student(23, "XYZ"));
        list.add(new Student(22, "ABC"));
        list.add(new Student(20, "PQR"));
        list.add(new Student(19, "IOP"));

       /* Iterator<Student> iterator = list.iterator();

        while (iterator.hasNext()) {
            list.remove(iterator.next());
            iterator.remove();
        }*/

        Iterator<Student> iter = list.iterator();

        while (iter.hasNext()) {
            //Student std = iter.next();

            iter.remove();
        }

        System.out.println(list);

    }
}

class Student {
    int age;
    String name;

    Student(final int age, final String name) {
        this.age = age;
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(final int age) {
        this.age = age;
    }

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
