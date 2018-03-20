package com.ratcoding.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ratcoding.domain.Product;
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

	// adding new material part

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result,
			HttpServletRequest httpServletRequest) {

		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			// exception handling level hard
			throw new RuntimeException(
					"unacceptable fields\n" + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = httpServletRequest.getSession().getServletContext().getRealPath("/");

		if (productImage != null) {
			try {
				productImage
						.transferTo(new File(rootDirectory + "resources\\images\\" + newProduct.getName() + ".jpg"));
			} catch (IllegalStateException illegalStateException) {
				throw new RuntimeException("file upload error IllegalStateException", illegalStateException);
			} catch (IOException iOException) {
				throw new RuntimeException("file upload error IOException", iOException);
			}
		}
		productService.addProduct(newProduct);
		return "redirect:/products";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
//		webDataBinder.setAllowedFields(allowedFields);
		webDataBinder.setDisallowedFields("unitsInOrder", "discounted");
	}
	// end adding
}
