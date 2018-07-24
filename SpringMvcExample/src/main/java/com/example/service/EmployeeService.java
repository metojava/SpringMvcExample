package com.example.service;

import java.util.List;

import com.example.domain.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Employee employee);

	public Employee getEmployee(int employeeid);

	public Employee updateEmployee(Employee employee);
}
