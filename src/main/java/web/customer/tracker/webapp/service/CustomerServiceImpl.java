package web.customer.tracker.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.customer.tracker.webapp.dao.CustomerDAO;
import web.customer.tracker.webapp.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers()
	{
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer)
	{
		customerDAO.addCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId)
	{
		return customerDAO.getCustomer(customerId);
	}
}
