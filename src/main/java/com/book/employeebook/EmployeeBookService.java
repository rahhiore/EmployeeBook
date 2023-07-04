package com.book.employeebook;

import java.util.Collection;
import java.util.List;

public interface EmployeeBookService {
    String homePage();
    Employee findEmployee(String firsName, String lastName);
    void addEmployee(String firsName, String lastName);
    void removeEmployee(String firsName, String lastName);
    Collection<Employee> showAllEmployees();
}
