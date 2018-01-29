package com.ratcoding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String test(Model model) {
		model.addAttribute("greeting", "welcome");
		model.addAttribute("tagline", "at ratcoding shop");

		return "welcome";

	}
	
}
