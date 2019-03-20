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
		Query<Customer> customerQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		return customerQuery.getResultList();
	}

	@Override
	public void addCustomer(Customer customer)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerId)
	{
		return sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}

	@Override
	public void delete(int customerId)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String searchName)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query;
		if (searchName != null && searchName.trim().length() > 0)
		{
			query = currentSession.createQuery("from Customer where lower(firstName) like :searchName or lower(lastName) like :searchName", Customer.class);
			query.setParameter("searchName", "%" + searchName.toLowerCase() + "%");
		}
		else
		{
			query = currentSession.createQuery("from Customer", Customer.class);
		}
		return query.getResultList();
	}
}
