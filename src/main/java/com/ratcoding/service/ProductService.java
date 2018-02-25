package com.ratcoding.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ratcoding.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

	List<Product> getProductByCriterias(String category, String manufacturer, BigDecimal price1, BigDecimal price2);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParms);

	Product getProductById(String productId);
}
