package web.customer.tracker.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

	@GetMapping("/showFormForUdpate")
	public String showFormForUdpate(@RequestParam("customId") int customerId, Model model)
	{
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customId") int customerId)
	{
		customerService.delete(customerId);
		return "redirect:/customer/list";
	}
}
