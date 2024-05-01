package com.employee.exception;

public class EmployeeNotFound extends RuntimeException {
	 public EmployeeNotFound(String message) {
	        super(message);
	    }
}
