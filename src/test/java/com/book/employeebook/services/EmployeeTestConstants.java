package com.book.employeebook.services;

import com.book.employeebook.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeTestConstants {
    public static final String FIRST_NAME = "Max";
    public static final String LAST_NAME = "Smith";
    public static final String FIRST_NAME2 = "Ivan";
    public static final String LAST_NAME2 = "Troy";
    public static final String FIRST_NAME3 = "Paul";
    public static final String LAST_NAME3 = "Scott";

    public static final Integer WAGE = 200000;
    public static final Integer DEPARTMENT = 2;
    public static final Integer DEPARTMENT2 = 5;

    public static final Employee newEmployeeAdd1 = new Employee(FIRST_NAME, LAST_NAME, 150000, DEPARTMENT);
    public static final Employee newEmployeeAdd2 = new Employee(FIRST_NAME2, LAST_NAME3, 2000000, DEPARTMENT2);
    public static final Employee newEmployeeAdd3 = new Employee(FIRST_NAME2, LAST_NAME2, 180000, DEPARTMENT);
    public static final Employee newEmployeeAdd4 = new Employee(FIRST_NAME3, LAST_NAME3, 100000, DEPARTMENT2);
    public static final List<Employee> EMPLOYEES = List.of(newEmployeeAdd1, newEmployeeAdd3);
    public static final List<Employee> EMPLOYEES2 = List.of(newEmployeeAdd1, newEmployeeAdd3, newEmployeeAdd2, newEmployeeAdd4);
    public static final Integer TOTAL_WAGE = EMPLOYEES.stream().mapToInt(Employee::getWage).sum();
    public static final Map<Integer, List<Employee>> EMPLOYEE_BY_DEPARTMENT = EMPLOYEES2.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
}
