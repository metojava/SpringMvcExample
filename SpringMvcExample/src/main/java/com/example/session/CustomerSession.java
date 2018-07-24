package com.example.session;

import java.util.List;

import com.example.domain.Customer;

public interface CustomerSession {

	public void addCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public void deleteCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomer(int cid);
	
}
