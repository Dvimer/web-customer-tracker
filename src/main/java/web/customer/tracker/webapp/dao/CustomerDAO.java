package web.customer.tracker.webapp.dao;

import web.customer.tracker.webapp.entity.Customer;

import java.util.List;

public interface CustomerDAO
{
	List<Customer> getCustomers();

	void addCustomer(Customer customer);

	Customer getCustomer(int customerId);
}
