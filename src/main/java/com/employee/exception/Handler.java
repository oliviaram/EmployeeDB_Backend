package com.employee.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class Handler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeExists.class)
    public Map<String, String> userNotFound(EmployeeExists ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFound.class)
    public Map<String, String> userNotFound(EmployeeNotFound ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
}
