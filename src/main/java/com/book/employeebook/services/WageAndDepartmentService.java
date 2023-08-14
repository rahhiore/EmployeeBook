package com.book.employeebook.services;

import com.book.employeebook.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface WageAndDepartmentService {
    Integer getDepartmentSalarySum(Integer department);
    Employee getMaxSalaryByDepartment(Integer department);
    Employee getMinSalaryByDepartment(Integer department);
    Collection<Employee> getAllEmployeesByDepartment(Integer department);
    Map<Integer, List<Employee>> getAllEmployeesGroupByDepartment();
}
