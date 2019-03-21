package web.customer.tracker.webapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.customer.tracker.webapp.entity.Insurance;

import java.util.List;

@Repository
public class InsuranceDAOImpl implements InsuranceDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Insurance> getUnsurances()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Insurance> customerQuery = currentSession.createQuery("from Insurance", Insurance.class);
		return customerQuery.getResultList();
	}

	@Override
	public void addInsurance(Insurance insurance)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(insurance);
	}

	@Override
	public Insurance getInsurance(int insuranceId)
	{
		return sessionFactory.getCurrentSession().get(Insurance.class, insuranceId);
	}
}
