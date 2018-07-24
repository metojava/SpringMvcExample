package com.example.session;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;

@Repository
@Transactional
public class CustomerSessionImpl implements CustomerSession {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(customer);
		session.flush();
		session.close();
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<Customer> customers = session.createQuery("from Customer").list();
		session.flush();
		session.close();
		return customers;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		session.delete(customer);
		session.flush();
		session.close();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		session.update(customer);
		session.flush();
		session.close();
		return customer;
	}

	@Override
	public Customer getCustomer(int cid) {
		Session session = sessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, cid);
		session.flush();
		session.close();
		return customer;
	}

}
