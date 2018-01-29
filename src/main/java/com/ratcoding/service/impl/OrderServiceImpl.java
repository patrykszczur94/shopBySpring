package com.ratcoding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratcoding.domain.repository.ProductRepository;
import com.ratcoding.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void makeOrder(String productId, int amount) {

		if (productRepository.getProductById(productId).getUnitsInStock() < amount) {
			throw new IllegalArgumentException("not enough material in stock");
		} else {
			productRepository.getProductById(productId)
					.setUnitsInStock(productRepository.getProductById(productId).getUnitsInStock() - amount);
		}

	}

}
