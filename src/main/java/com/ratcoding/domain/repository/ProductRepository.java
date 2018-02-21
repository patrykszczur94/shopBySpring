package com.ratcoding.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ratcoding.domain.Product;

public interface ProductRepository {

	List<Product> getAllProctucts();

	Product getProductById(String id);
	
	List<Product> getProductByCategory(String category);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParms);
	
}
