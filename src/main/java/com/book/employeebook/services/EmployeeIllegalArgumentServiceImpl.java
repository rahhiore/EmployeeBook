package com.book.employeebook.services;

import com.book.employeebook.exceptions.EmployeeIllegalArgumentException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
@Service
public class EmployeeIllegalArgumentServiceImpl implements EmployeeIllegalArgumentService {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }
    private void validateName(String name) {
        if (!StringUtils.isAlpha(name)) {
            throw new EmployeeIllegalArgumentException("Bad firstname: " + name);
        }
    }

}
