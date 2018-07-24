package com.example.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public ModelAndView getAllCustomers() {
		logger.debug("entered getAllCustomers() method of CustomerController");
		ModelAndView mv = new ModelAndView();
		mv.addObject("customers", customerService.getAllCustomers());
		mv.setViewName("customers/customersList");
		logger.debug("leaving getAllCustomers() method of CustomerController");
		return mv;
	}

	@RequestMapping(path = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView addCustomer() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer", new Customer());
		mv.setViewName("customers/customerForm");
		return mv;
	}

	@RequestMapping("/saveCustomer")
	public ModelAndView saveCustomer(
			@ModelAttribute("customer") @Valid Customer customer,
			BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("customers/customerForm", "customer",
					customer);
		if (customer.getCid() == null) {
			customerService.addCustomer(customer);
		} else {
			customerService.updateCustomer(customer);
		}
		return new ModelAndView("redirect:/customer/list");
	}

	@RequestMapping(path = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editCustomer(@RequestParam("cid") int cid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer", customerService.getCustomer(cid));
		mv.setViewName("customers/customerForm");
		return mv;
	}

	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(@RequestParam("id") int id) {
		Customer emp = customerService.getCustomer(id);
		customerService.deleteCustomer(emp);
		return new ModelAndView("redirect:/customer/list");
	}

}
