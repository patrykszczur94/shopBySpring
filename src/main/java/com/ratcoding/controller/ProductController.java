package com.ratcoding.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sound.sampled.LineListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		// temporary we can transfer null here
		model.addAttribute("products", productService.getProductByCriterias(productCategory, null, null, null));
		return "products";
	}

	@RequestMapping("filter/{ByCriteria}")
	public String getProductByCategory(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParms,
			Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParms));
		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping("xx")
	public String filterProducts(@RequestParam("manufacturer") String manufacturer,
			@RequestParam("highPrice") String highPrice, @RequestParam("lowPrice") String lowPrice, Model model) {
		BigDecimal price1 = new BigDecimal(highPrice);
		BigDecimal price2 = new BigDecimal(lowPrice);

		model.addAttribute("products", productService.getProductByCriterias(null, manufacturer, price1, price2));
		return "products";
	}
}
