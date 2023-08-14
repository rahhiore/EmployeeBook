package com.book.employeebook.services;

import com.book.employeebook.Employee;
import com.book.employeebook.exceptions.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {
    private final Map<String, Employee> employees;
    private final EmployeeIllegalArgumentService illegalArgumentService;
    public EmployeeBookServiceImpl(EmployeeIllegalArgumentService illegalArgumentService) {
        this.employees = new HashMap<>();
        this.illegalArgumentService = illegalArgumentService;
    }

    @Override
    public String homePage() {
        return null;
    }

    @Override
    public Employee findEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        } else {
            return employee;
        }
    }
    @Override
    public Employee addEmployee(String firsName, String lastName, Integer wage, Integer department) {
        StringUtils.capitalize(firsName);
        StringUtils.capitalize(lastName);
        Employee employee = new Employee(firsName, lastName, wage, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            illegalArgumentService.validate(firsName, lastName);
            employees.put(employee.getFullName(), employee);
        }
        return employee;
    }
    @Override
    public Employee removeEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        } else {
            employees.remove(employee.getFullName());
        }
        return employee;
    }
    @Override
    public Collection<Employee> showAllEmployees() {
        return employees.values();
    }
}
