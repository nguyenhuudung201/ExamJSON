package com.class2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private int id;
    private String email;
    private String department;
    private String position;
    private String hireDate;
    private  int salary;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                ", age=" + age +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getHireDate() {
        return hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isActive() {
        return active;
    }

    private boolean active ;




    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    int age;

    public Person() {


    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
