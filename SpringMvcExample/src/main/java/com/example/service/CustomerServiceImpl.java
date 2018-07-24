package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;
import com.example.session.CustomerSession;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerSession customerSession;

	@Override
	public void addCustomer(Customer customer) {
		customerSession.addCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerSession.getAllCustomers();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerSession.deleteCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerSession.updateCustomer(customer);
	}

	@Override
	public Customer getCustomer(int cid) {
		return customerSession.getCustomer(cid);
	}

}
