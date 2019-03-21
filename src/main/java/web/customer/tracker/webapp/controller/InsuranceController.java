package web.customer.tracker.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.customer.tracker.webapp.entity.Insurance;
import web.customer.tracker.webapp.service.InsuranceService;

@Controller
@RequestMapping("/insurance")
public class InsuranceController
{
	@Autowired
	InsuranceService insuranceService;

	@GetMapping("/list")
	public String listController(Model model)
	{
		model.addAttribute("insurances", insuranceService.getInsurances());
		return "list-insurances";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		Insurance insurance = new Insurance();
		model.addAttribute("insurance", insurance);
		return "insurance-form";
	}

	@PostMapping("/saveInsurance")
	public String saveInsurance(@ModelAttribute("insurance") Insurance insurance)
	{
		insuranceService.addInsurance(insurance);
		return "redirect:/insurance/list";
	}

	@GetMapping("/showFormForUdpate")
	public String showFormForUdpate(@RequestParam("insuranceId") int insuranceId, Model model)
	{
		Insurance insurance = insuranceService.getInsurance(insuranceId);
		model.addAttribute("insurance", insurance);
		return "insurance-form";
	}
//
//	@GetMapping("/delete")
//	public String delete(@RequestParam("customId") int customerId)
//	{
//		customerService.delete(customerId);
//		return "redirect:/customer/list";
//	}
//
//	@GetMapping("/search")
//	public String search(@RequestParam("searchName") String searchName,
//	                              Model theModel)
//	{
//		List<Customer> customers = customerService.searchCustomers(searchName);
//		theModel.addAttribute("customers", customers);
//		return "list-customers";
//	}
}
