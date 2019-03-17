package web.customer.tracker.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.customer.tracker.webapp.entity.Customer;
import web.customer.tracker.webapp.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	CustomerService customerService;

	@GetMapping("/list")
	public String listController(Model model)
	{
		model.addAttribute("customers", customerService.getCustomers());
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{

		customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}
}
