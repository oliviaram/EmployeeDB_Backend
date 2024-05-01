package com.employee.exception;

public class EmployeeExists extends RuntimeException {
	public EmployeeExists(String message) {
        super(message);
    }
}
