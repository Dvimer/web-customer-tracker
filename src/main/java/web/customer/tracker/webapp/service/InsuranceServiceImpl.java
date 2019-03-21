package web.customer.tracker.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.customer.tracker.webapp.dao.InsuranceDAO;
import web.customer.tracker.webapp.entity.Insurance;

import java.util.List;
@Service
public class InsuranceServiceImpl implements InsuranceService
{
	@Autowired
	private InsuranceDAO insuranceDAO;

	@Override
	@Transactional
	public List<Insurance> getInsurances()
	{
		return insuranceDAO.getUnsurances();
	}

	@Override
	@Transactional
	public void addInsurance(Insurance insurance)
	{
		insuranceDAO.addInsurance(insurance);
	}

	@Override
	@Transactional
	public Insurance getInsurance(int insuranceId)
	{
		return insuranceDAO.getInsurance(insuranceId);
	}

}
