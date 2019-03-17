package web.customer.tracker.webapp.service;

import web.customer.tracker.webapp.entity.Customer;

import java.util.List;

public interface CustomerService
{
	List<Customer> getCustomers();

	void addCustomer(Customer customer);
}