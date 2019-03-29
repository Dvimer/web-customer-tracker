package web.customer.tracker.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.customer.tracker.webapp.entity.Insurance;
import web.customer.tracker.webapp.service.InsuranceService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.RoundingMode;

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
	public String saveInsurance(@ModelAttribute("insurance") @RequestBody @Valid Insurance insurance)
	{
		if (insurance.getDiscount() != null && insurance.getPrice() != null)
		{
			insurance.setDiscountPrice(insurance.getPrice().divide(insurance.getDiscount(), 2, RoundingMode.HALF_UP));
		}
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
	@ExceptionHandler
	public ResponseEntity handleException(Throwable th, HttpServletRequest request)
	{
		/// TODO: 3/29/19 Отлавливать ошибки
		System.out.println(th);
		return null;
	}
}
