package com.book.employeebook.services;

import com.book.employeebook.Employee;
import com.book.employeebook.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WageAndDepartmentServiceImpl implements WageAndDepartmentService {
    private final EmployeeBookService employeeBookService;
    public WageAndDepartmentServiceImpl(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }
    @Override
    public Employee getMaxSalaryByDepartment(Integer department) {
        return employeeBookService.showAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparingInt(Employee::getWage))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getMinSalaryByDepartment(Integer department) {
        return employeeBookService.showAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparingInt(Employee::getWage))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getAllEmployeesByDepartment(Integer department) {
        return employeeBookService.showAllEmployees().stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupByDepartment() {
        return employeeBookService.showAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
