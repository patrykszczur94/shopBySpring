package com.ratcoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ratcoding.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/customers")
	public String showAllCustomers(Model model) {
		model.addAttribute("customers", customerService.getAllCustoemrs());
		return "customer";
	}
}
