package com.book.employeebook;

import com.book.employeebook.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {
    private final Map<String, Employee> employees;
    private static final int quantity = 50;

    public EmployeeBookServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public String homePage() {
        return null;
    }

    @Override
    public Employee findEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (!employees.containsKey(employee.getLastName())) {
            throw new EmployeeNotFoundException();
        } else {
            return employee;
        }

    }
    @Override
    public void addEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (employees.containsKey(employee.getLastName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put(employee.getFullName(), employee);
        }
    }
    public void removeEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (!employees.containsKey(employee.getLastName())) {
            throw new EmployeeNotFoundException();
        } else {
            employees.remove(employee.getFullName());
        }
    }
    @Override
    public Collection<Employee> showAllEmployees() {
        return employees.values();
    }
}
