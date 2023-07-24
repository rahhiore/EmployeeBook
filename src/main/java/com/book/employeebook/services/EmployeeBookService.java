package com.book.employeebook.services;
import com.book.employeebook.Employee;
import java.util.Collection;

public interface EmployeeBookService {
    String homePage();
    Collection<Employee> findEmployee(String firsName, String lastName);
    void addEmployee(String firsName, String lastName, Integer wage, Integer department);
    void removeEmployee(String firsName, String lastName);
    Collection<Employee> showAllEmployees();
}
