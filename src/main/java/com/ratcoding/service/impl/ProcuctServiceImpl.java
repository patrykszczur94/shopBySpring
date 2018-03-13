package com.ratcoding.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratcoding.domain.Product;
import com.ratcoding.domain.repository.ProductRepository;
import com.ratcoding.service.ProductService;

@Service
public class ProcuctServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProctucts();
	}

	@Override
	public List<Product> getProductByCriterias(String category, String manufacturer, BigDecimal price1,
			BigDecimal price2) {
		return productRepository.getProductByCriterias(category, manufacturer, price1, price2);
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParms) {
		return productRepository.getProductsByFilter(filterParms);
	}

	@Override
	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

}
