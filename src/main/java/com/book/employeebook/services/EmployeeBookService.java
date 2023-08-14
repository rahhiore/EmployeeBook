package com.book.employeebook.services;
import com.book.employeebook.Employee;
import java.util.Collection;

public interface EmployeeBookService {
    String homePage();
    Employee findEmployee(String firsName, String lastName);
    Employee addEmployee(String firsName, String lastName, Integer wage, Integer department);
    Employee removeEmployee(String firsName, String lastName);
    Collection<Employee> showAllEmployees();
}
