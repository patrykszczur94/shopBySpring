package com.ratcoding.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ratcoding.domain.Product;

public interface ProductRepository {

	List<Product> getAllProctucts();

	Product getProductById(String id);
	
	List<Product> getProductByCriterias(String category, String manufacturer, BigDecimal price1, BigDecimal price2);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParms);
	
	void addProduct(Product product);
	
}
