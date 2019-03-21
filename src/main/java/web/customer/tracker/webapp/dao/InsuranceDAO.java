package web.customer.tracker.webapp.dao;

import web.customer.tracker.webapp.entity.Customer;
import web.customer.tracker.webapp.entity.Insurance;

import java.util.List;

public interface InsuranceDAO
{
	List<Insurance> getUnsurances();

	void addInsurance(Insurance insurance);

	Insurance getInsurance(int insuranceId);
}
