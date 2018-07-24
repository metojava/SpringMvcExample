package com.example.session;

import java.util.List;

import com.example.domain.Employee;

public interface EmployeeSession {

	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployee(int employeeid);

}
