package com.ratcoding.domain.repository;

import java.util.List;

import com.ratcoding.domain.Product;

public interface ProductRepository {

	List<Product> getAllProctucts();

	Product getProductById(String id);
	
	List<Product> getProductByCategory(String category);
}
