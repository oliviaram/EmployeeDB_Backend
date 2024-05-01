package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface IEmployeeService {
	List<Employee> getEmployee();
	Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
}
