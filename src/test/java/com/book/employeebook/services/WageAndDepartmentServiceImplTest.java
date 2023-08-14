package com.book.employeebook.services;

import com.book.employeebook.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.book.employeebook.services.EmployeeTestConstants.*;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WageAndDepartmentServiceImplTest {
    @Mock
    private EmployeeBookServiceImpl employeeBookService;
    @InjectMocks
    private WageAndDepartmentServiceImpl wageAndDepartmentService;
    @Test
    void getDepartmentSalarySum() {
        when(employeeBookService.showAllEmployees()).thenReturn(EMPLOYEES);
        assertEquals(TOTAL_WAGE, wageAndDepartmentService.getDepartmentSalarySum(DEPARTMENT));
    }

    @Test
    void getMaxSalaryByDepartment() {
        when(employeeBookService.showAllEmployees()).thenReturn(EMPLOYEES);
        assertEquals(newEmployeeAdd3, wageAndDepartmentService.getMaxSalaryByDepartment(DEPARTMENT));
    }
    @Test
    void tryGetMaxSalaryByDepartment() {
        when(employeeBookService.showAllEmployees()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> wageAndDepartmentService.getMaxSalaryByDepartment(DEPARTMENT));
    }
    @Test
    void getMinSalaryByDepartment() {
        when(employeeBookService.showAllEmployees()).thenReturn(EMPLOYEES);
        assertEquals(newEmployeeAdd1, wageAndDepartmentService.getMinSalaryByDepartment(DEPARTMENT));
    }
    @Test
    void tryGetMinSalaryByDepartment() {
        when(employeeBookService.showAllEmployees()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> wageAndDepartmentService.getMinSalaryByDepartment(DEPARTMENT2));
    }
    @Test
    void getAllEmployeesByDepartment() {
        when(employeeBookService.showAllEmployees()).thenReturn(EMPLOYEES2);
        assertEquals(EMPLOYEES, wageAndDepartmentService.getAllEmployeesByDepartment(DEPARTMENT));
        assertEquals(EMPLOYEES, wageAndDepartmentService.getAllEmployeesByDepartment(DEPARTMENT));
    }

    @Test
    void getAllEmployeesGroupByDepartment() {
        when(employeeBookService.showAllEmployees()).thenReturn(EMPLOYEES2);
        assertEquals(EMPLOYEE_BY_DEPARTMENT, wageAndDepartmentService.getAllEmployeesGroupByDepartment());
    }
}