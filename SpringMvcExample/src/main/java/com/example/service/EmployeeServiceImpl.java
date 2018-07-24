package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Employee;
import com.example.session.EmployeeSession;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeSession employeeSession;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeSession.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeSession.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee employee) {
		employeeSession.deleteEmployee(employee);
	}

	public Employee getEmployee(int empid) {
		return employeeSession.getEmployee(empid);
	}

	public Employee updateEmployee(Employee employee) {
		return employeeSession.updateEmployee(employee);
	}

}
