package com.ratcoding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratcoding.domain.Customer;
import com.ratcoding.domain.repository.CustomerRepository;
import com.ratcoding.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustoemrs() {
		return customerRepository.getAllCustomers();
	}

}
