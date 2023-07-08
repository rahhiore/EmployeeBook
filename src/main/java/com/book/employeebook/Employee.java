package com.book.employeebook;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private String firstName;
    private String lastName;
    private String fullName;
    private Integer wage;
    private Integer department;
    public Employee(String firstName, String lastName, Integer wage, Integer department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.wage = wage;
        this.department = department;
    }
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.wage = getWage();
        this.department = getDepartment();
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    @JsonIgnore
    public String getFullName() {
        return fullName;
    }

    public Integer getWage() {
        return wage;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getWage(), employee.getWage()) && Objects.equals(getDepartment(), employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getWage(), getDepartment());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", wage='" + wage + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
