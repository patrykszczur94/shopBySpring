package com.ratcoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ratcoding.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/p1/3")
	public String order() {
		orderService.makeOrder("p1", 3);
		return "redirect:/products";
	}
}
