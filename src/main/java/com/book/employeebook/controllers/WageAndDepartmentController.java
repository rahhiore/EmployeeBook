package com.book.employeebook.controllers;

import com.book.employeebook.Employee;
import com.book.employeebook.services.WageAndDepartmentService;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(path = "/{id}/salary/sum")
    public Integer getDepartmentSalarySum(@PathVariable("id") Integer department) {
        return wageAndDepartmentService.getDepartmentSalarySum(department);
    }
    @GetMapping(path = "/{id}/salary/max")
    public Employee getMaxSalaryByDepartment(@PathVariable("id") Integer department) {
        return wageAndDepartmentService.getMaxSalaryByDepartment(department);
    }
    @GetMapping(path = "/{id}/salary/min")
    public Employee getMinSalaryByDepartment(@PathVariable("id") Integer department) {
        return wageAndDepartmentService.getMinSalaryByDepartment(department);
    }
    @GetMapping(path = "{id}/employees")
    public Collection<Employee> getAllEmployeesByDepartment(@PathVariable("id") Integer department) {
        return wageAndDepartmentService.getAllEmployeesByDepartment(department);
    }
    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> getAllEmployeesGroupByDepartment() {
        return wageAndDepartmentService.getAllEmployeesGroupByDepartment();
    }
}
