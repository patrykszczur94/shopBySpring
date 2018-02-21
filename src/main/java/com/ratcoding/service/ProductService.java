package com.ratcoding.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ratcoding.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();
	
	List<Product> getProductByCategory(String category);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParms);
}
