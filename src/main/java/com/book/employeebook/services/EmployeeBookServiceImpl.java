package com.book.employeebook.services;

import com.book.employeebook.Employee;
import com.book.employeebook.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {
    private final Map<String, Employee> employees;
    public EmployeeBookServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public String homePage() {
        return null;
    }

    @Override
    public Collection<Employee> findEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        } else {
            return employees.values();
        }

    }
    @Override
    public void addEmployee(String firsName, String lastName, Integer wage, Integer department) {
        Employee employee = new Employee(firsName, lastName, wage, department);
        if (employees.containsKey(employee.getLastName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put(employee.getFullName(), employee);
        }
    }
    public void removeEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
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
