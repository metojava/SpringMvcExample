package com.example.session;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Employee;

@Repository
@Transactional
public class EmployeeSessionImpl implements EmployeeSession {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(employee);
		session.flush();
		session.close();
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		List<Employee> employees = session.createQuery("from Employee").list();
		session.flush();
		session.close();

		return employees;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.delete(employee);
		session.flush();
		session.close();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.update(employee);
		session.flush();
		session.close();
		return employee;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.get(Employee.class, employeeId);

		session.flush();
		session.close();
		return employee;
	}
}
