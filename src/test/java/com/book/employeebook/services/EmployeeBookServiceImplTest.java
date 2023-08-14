package com.book.employeebook.services;

import com.book.employeebook.Employee;
import com.book.employeebook.exceptions.EmployeeAlreadyAddedException;
import com.book.employeebook.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static com.book.employeebook.services.EmployeeTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeBookServiceImplTest {
    private EmployeeIllegalArgumentServiceImpl employeeIllegalArgumentService = new EmployeeIllegalArgumentServiceImpl();
    private EmployeeBookServiceImpl employeeBookService = new EmployeeBookServiceImpl(employeeIllegalArgumentService);
    @Test
    public void addEmployee() {
        Employee employee = new Employee(FIRST_NAME, LAST_NAME, WAGE, DEPARTMENT);
        assertFalse(employeeBookService.showAllEmployees().contains(employee));
        Employee newEmployeeAdd = employeeBookService.addEmployee(FIRST_NAME, LAST_NAME, WAGE, DEPARTMENT);
        assertEquals(newEmployeeAdd, employee);
        assertTrue(employeeBookService.showAllEmployees().contains(employee));
    }
    @Test
    public void tryGetException() {
        Employee newEmployeeAdd = employeeBookService.addEmployee(FIRST_NAME, LAST_NAME, WAGE, DEPARTMENT);
        assertTrue(employeeBookService.showAllEmployees().contains(newEmployeeAdd));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeBookService.addEmployee(FIRST_NAME, LAST_NAME, WAGE, DEPARTMENT));
    }
    @Test
    public void removeEmployee() {
        Employee newEmployeeAdd = employeeBookService.addEmployee(FIRST_NAME2, LAST_NAME2, WAGE, DEPARTMENT);
        assertTrue(employeeBookService.showAllEmployees().contains(newEmployeeAdd));
        assertEquals(1, employeeBookService.showAllEmployees().size());
        Employee removeAddedEmployee = employeeBookService.removeEmployee(FIRST_NAME2, LAST_NAME2);
        assertFalse(employeeBookService.showAllEmployees().contains(newEmployeeAdd));
        assertEquals(0, employeeBookService.showAllEmployees().size());

    }
    @Test
    public void tryRemoveEmployee(){
        assertThrows(EmployeeNotFoundException.class, () -> employeeBookService.removeEmployee(FIRST_NAME2, LAST_NAME2));
    }
    @Test
    public void findEmployee() {
        Employee newEmployeeAdd = employeeBookService.addEmployee(FIRST_NAME3, LAST_NAME3, WAGE, DEPARTMENT);
        assertEquals(newEmployeeAdd.getFullName(), employeeBookService.findEmployee(FIRST_NAME3, LAST_NAME3).getFullName());
    }
    @Test
    public void tryFindEmployee() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeBookService.removeEmployee(FIRST_NAME3, LAST_NAME3));
    }
    @Test
    public void showAllEmployees() {
        Employee newEmployeeAdd1 = employeeBookService.addEmployee(FIRST_NAME, LAST_NAME, WAGE, DEPARTMENT);
        Employee newEmployeeAdd2 = employeeBookService.addEmployee(FIRST_NAME2, LAST_NAME2, WAGE, DEPARTMENT);
        Employee newEmployeeAdd3 = employeeBookService.addEmployee(FIRST_NAME3, LAST_NAME3, WAGE, DEPARTMENT);
        Collection<Employee> employees = employeeBookService.showAllEmployees();
        assertIterableEquals(List.of(newEmployeeAdd3, newEmployeeAdd1, newEmployeeAdd2), employees);

    }
}