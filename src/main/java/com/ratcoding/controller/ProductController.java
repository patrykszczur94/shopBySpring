package com.ratcoding.controller;

import java.util.List;
import java.util.Map;

import javax.sound.sampled.LineListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ratcoding.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping
	public String list(Model model) {

		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/{category}")
	public String getProductByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute("products", productService.getProductByCategory(productCategory));
		return "products";
	}
	
	@RequestMapping("filter/{ByCriteria}")
	public String getProductByCategory(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParms, Model model) { 
		model.addAttribute("products", productService.getProductsByFilter(filterParms));
		return "products";
	}
}
