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

import com.example.domain.Employee;
import com.example.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private final Logger logger = LoggerFactory
			.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/list")
	public ModelAndView getAllEmployees() {
		logger.debug("entered getAllEmployees() method of EmployeeController");
		ModelAndView mv = new ModelAndView();
		mv.addObject("employees", employeeService.getAllEmployees());
		mv.setViewName("employees/employeesList");
		logger.debug("leaving getAllEmployees() method of EmployeeController");
		return mv;
	}

	@RequestMapping(path = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", new Employee());
		mv.setViewName("employees/employeeForm");
		return mv;
	}

	@RequestMapping("/saveEmployee")
	public ModelAndView saveEmployee(
			@ModelAttribute("employee") @Valid Employee employee,
			BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("employees/employeeForm", "employee",
					employee);
		if (employee.getId() == null) {
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/employee/list");
	}

	@RequestMapping(path = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", employeeService.getEmployee(id));
		mv.setViewName("employees/employeeForm");
		return mv;
	}

	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam("id") int id) {
		Employee emp = employeeService.getEmployee(id);
		employeeService.deleteEmployee(emp);
		return new ModelAndView("redirect:/employee/list");
	}

}
