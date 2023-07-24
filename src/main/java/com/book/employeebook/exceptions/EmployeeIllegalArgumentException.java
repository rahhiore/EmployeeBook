package com.book.employeebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeIllegalArgumentException extends RuntimeException {
    public EmployeeIllegalArgumentException(String message) {
        super(message);
    }
}
