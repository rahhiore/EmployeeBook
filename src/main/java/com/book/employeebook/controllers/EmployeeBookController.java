package com.book.employeebook.controllers;
import com.book.employeebook.Employee;
import com.book.employeebook.services.EmployeeBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class EmployeeBookController {
    private final EmployeeBookService employeeService;

    public EmployeeBookController(EmployeeBookService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String homePage() {
        return "hello world!";
    }
    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("wage") Integer wage,
                                @RequestParam("department") Integer department) {
        Employee employee = new Employee(firstName, lastName, wage, department);
        employeeService.addEmployee(firstName, lastName, wage, department);
        return employee;
    }
    @GetMapping(path = "/remove")
    public void removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        employeeService.removeEmployee(firstName, lastName);
    }
    @GetMapping(path = "/showAll")
    public ResponseEntity<Collection<Employee>> showAllEmployees() {
        Collection<Employee> employees = employeeService.showAllEmployees();
        return ResponseEntity.ok(employees);
    }

}
