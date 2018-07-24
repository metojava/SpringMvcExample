package com.example.service;

import java.util.List;

import com.example.domain.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public void deleteCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomer(int cid);
}
