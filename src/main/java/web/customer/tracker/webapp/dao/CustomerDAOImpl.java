package web.customer.tracker.webapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.customer.tracker.webapp.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> customerQuery = currentSession.createQuery("from Customer", Customer.class);
		return customerQuery.getResultList();
	}

	@Override
	public void addCustomer(Customer customer)
	{
		sessionFactory.getCurrentSession().save(customer);
	}
}
