package com.app.testCodes;

public class EmployeeDemo {

    public static void main(String[] args) {
        Employee emp = new Employee(84);

        changeEmployee(emp);

        System.out.println(emp.getId());
    }

    private static void changeEmployee(Employee standard) {
        Employee another = new Employee(100);
        standard = another;
        //return standard;
    }
}
