package com.book.employeebook.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeAlreadyAddedException extends RuntimeException{
}
