package com.ratcoding.domain.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.ratcoding.domain.Product;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> products = new ArrayList<Product>();

	public InMemoryProductRepository() {

		Product iphoneX = new Product("p1", "iphone x", new BigDecimal("5000"));
		iphoneX.setProductId("p1");
		iphoneX.setDescription("iPhone is very expensive phone");
		iphoneX.setManufacturer("Apple");
		iphoneX.setUnitsInStock(10);
		iphoneX.setCategory("smartphone");

		Product iphone8 = new Product("p2", "iphone 8", new BigDecimal("3000"));
		iphone8.setDescription("iPhone is very expensive phone");
		iphone8.setManufacturer("Apple");
		iphone8.setUnitsInStock(10);
		iphone8.setCategory("smartphone");

		Product iphone7 = new Product("p3", "iphone 7", new BigDecimal("2000"));
		iphone7.setDescription("iPhone is very expensive phone");
		iphone7.setManufacturer("Apple");
		iphone7.setUnitsInStock(10);
		iphone7.setCategory("smartphone");

		Product thinkPad = new Product("p4", "ThinkPad T530i", new BigDecimal("1000"));
		thinkPad.setDescription("my notebook");
		thinkPad.setManufacturer("IBM");
		thinkPad.setUnitsInStock(1);
		thinkPad.setCategory("notebook");

		products.add(iphoneX);
		products.add(iphone8);
		products.add(iphone7);
		products.add(thinkPad);
	}

	@Override
	public List<Product> getAllProctucts() {
		return products;
	}

	@Override
	public Product getProductById(String id) {
		Product neededProduct = null;

		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();

			if (product.getProductId().equals(id)) {
				neededProduct = product;
				break;
			}
		}

		if (neededProduct == null) {
			throw new IllegalArgumentException("can't find any article");
		}
		return neededProduct;
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		List<Product> neededProducts = new ArrayList<Product>();

		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();

			if (product.getCategory().equals(category)) {
				neededProducts.add(product);
			}
		}

		if (neededProducts.isEmpty()) {
			throw new IllegalArgumentException("can't find any article");
		}
		return neededProducts;
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParms) {
 		Set<Product> produstsByBrand = new HashSet<Product>();
		Set<Product> produstsByCategory = new HashSet<Product>();
		
		// filterParms variable got from user
		Set<String> criterias = filterParms.keySet();
		// look for brand 
		if(criterias.contains("brand")) { 
			for (String brandname : filterParms.get("brand")) {
				for (Product product : products) {
					if(brandname.equals(product.getManufacturer())) { 
						produstsByBrand.add(product);
					}
				}
			}
		}
		// look for category 
		if(criterias.contains("category")) { 
			for(String category : filterParms.get("category")) { 
				produstsByCategory.addAll(getProductByCategory(category));
			}
		}
		
		if (!produstsByCategory.isEmpty() && !produstsByBrand.isEmpty()) {
			produstsByCategory.retainAll(produstsByBrand);
			return produstsByCategory;
		} else if (!produstsByCategory.isEmpty()) {
			return produstsByCategory;
		} else if (!produstsByBrand.isEmpty()) {
			return produstsByBrand;
		}
		return null;
	}
}
