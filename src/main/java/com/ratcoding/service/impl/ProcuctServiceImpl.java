package com.ratcoding.service.impl;

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
	public List<Product> getProductByCategory(String category) {
		return productRepository.getProductByCategory(category);
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParms) {
		return productRepository.getProductsByFilter(filterParms);
	}

}
