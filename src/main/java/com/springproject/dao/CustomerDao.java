package com.springproject.dao;

import java.util.List;

import com.springproject.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theCustomerId);
	
	public Customer getCustomerByname(String theCustomerName);

	public void deleteCustomer(int theCustomerId);
	
}
