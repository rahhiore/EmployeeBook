package com.book.employeebook.controllers;

import com.book.employeebook.Employee;
import com.book.employeebook.services.WageAndDepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class WageAndDepartmentController {
    private final WageAndDepartmentService wageAndDepartmentService;

    public WageAndDepartmentController(WageAndDepartmentService wageAndDepartmentService) {
        this.wageAndDepartmentService = wageAndDepartmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee getMaxSalaryByDepartment(@RequestParam("departmentId") Integer department) {
        return wageAndDepartmentService.getMaxSalaryByDepartment(department);
    }
    @GetMapping(path = "/min-salary")
    public Employee getMinSalaryByDepartment(@RequestParam("departmentId") Integer department) {
        return wageAndDepartmentService.getMinSalaryByDepartment(department);
    }
    @GetMapping(path = "/all", params = "departmentId")
    public Collection<Employee> getAllEmployeesByDepartment(@RequestParam("departmentId") Integer department) {
        return wageAndDepartmentService.getAllEmployeesByDepartment(department);
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAllEmployeesGroupByDepartment() {
        return wageAndDepartmentService.getAllEmployeesGroupByDepartment();
    }
}
