package com.example.controller;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.hsqldb.util.DatabaseManagerSwing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.Account;
import com.example.domain.Customer;
import com.example.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	private final Logger logger = LoggerFactory
			.getLogger(AccountController.class);

	@PostConstruct
	public void startDBManager() {

		DatabaseManagerSwing.main(new String[] { "--url",
				"jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });

	}
	
	@Autowired
	private AccountService accountService;

	@RequestMapping("/list")
	public ModelAndView getAllAccounts() {
		logger.debug("entered getAllAccounts() method of AccountController");
		ModelAndView mv = new ModelAndView();
		mv.addObject("accounts", accountService.getAllAccounts());
		mv.setViewName("accounts/accountsList");
		logger.debug("leaving getAllAccounts() method of AccountController");
		return mv;
	}

	@RequestMapping("/getAccount")
	public ModelAndView getAccount(@RequestParam("accno") Integer accno) {
		Account account = accountService.getAccount(accno);
		Customer customer = account.getCustomerList().get(0);
		ModelAndView mv = new ModelAndView();
		mv.addObject("account", account);
		mv.addObject("customer", customer);
		mv.setViewName("accounts/accountForm");
		return mv;
	}

	@RequestMapping(path = "/addAccount", method = RequestMethod.GET)
	public ModelAndView addAccount() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("account", new Account());
		mv.setViewName("accounts/accountForm");
		return mv;
	}

	@RequestMapping("/saveAccount")
	public ModelAndView saveAccount(
			@ModelAttribute("account") @Valid Account account,
			BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("accounts/accountForm", "account", account);
		if (account.getAccno() == null) {
			accountService.addAccount(account);
		} else {
			accountService.updateAccount(account);
		}
		return new ModelAndView("redirect:/account/list");
	}

	@RequestMapping(path = "/editAccount", method = RequestMethod.GET)
	public ModelAndView editAccount(@RequestParam("accno") Integer accno) {
		ModelAndView mv = new ModelAndView();

		Account account = accountService.getAccount(accno);
		//Customer customer = account.getCustomerList().get(0);
		mv.addObject("account", account);
		//mv.addObject("customer", customer);
		mv.setViewName("accounts/accountForm");
		return mv;
	}

	@RequestMapping("/deleteAccount")
	public ModelAndView deleteAccount(@RequestParam("accno") Integer accno) {
		Account acc = accountService.getAccount(accno);
		accountService.deleteAccount(acc);
		return new ModelAndView("redirect:/account/list");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "accessDenied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
}
