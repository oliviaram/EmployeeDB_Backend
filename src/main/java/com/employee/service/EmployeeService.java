package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeExists;
import com.employee.exception.EmployeeNotFound;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {
	private final EmployeeRepository employeeRepository;
	
	private boolean employeeExists(String email) {
        return employeeRepository.findByEmail(email).isPresent();
    }
	
	@Override
	public Employee addEmployee(Employee employee) {
		if (employeeExists(employee.getEmail())){
            throw new EmployeeExists(employee.getEmail() + " already exists");
        }
        return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		return employeeRepository.findById(id).map(emp -> {
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmail(employee.getEmail());
			emp.setRole(employee.getRole());
			emp.setSalary(employee.getSalary());
			return employeeRepository.save(emp);
		}).orElseThrow(() -> new EmployeeNotFound("Employee not found"));
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFound("No Employee [" + id + "] found"));
	}

	@Override
	public void deleteEmployee(Long id) {
		if(!employeeRepository.existsById(id)) {
			throw new EmployeeNotFound("Employee not found");
		}
		employeeRepository.deleteById(id);
	}
}
