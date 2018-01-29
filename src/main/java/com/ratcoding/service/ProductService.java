package com.ratcoding.service;

import java.util.List;

import com.ratcoding.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();
	
	List<Product> getProductByCategory(String category);
}
