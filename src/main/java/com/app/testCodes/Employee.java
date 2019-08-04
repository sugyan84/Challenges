package com.app.testCodes;

public class Employee {

    int id;
    Persona persona;

    public Employee(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }
}

class Persona {
    String name;
    int roll;
}
