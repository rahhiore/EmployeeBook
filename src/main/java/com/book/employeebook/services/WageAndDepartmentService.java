package com.book.employeebook.services;

import com.book.employeebook.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface WageAndDepartmentService {
    public Employee getMaxSalaryByDepartment(Integer department);
    public Employee getMinSalaryByDepartment(Integer department);
    public Collection<Employee> getAllEmployeesByDepartment(Integer department);
    public Map<Integer, List<Employee>> getAllEmployeesGroupByDepartment();
}
