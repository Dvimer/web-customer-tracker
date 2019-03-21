package web.customer.tracker.webapp.service;

import web.customer.tracker.webapp.entity.Insurance;

import java.util.List;

public interface InsuranceService
{
	List<Insurance> getInsurances();

	void addInsurance(Insurance insurance);

	Insurance getInsurance(int insuranceId);
}
