package com.ratcoding.domain.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ratcoding.domain.Customer;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	List<Customer> customers = new ArrayList<Customer>();

	public InMemoryCustomerRepository() {

		Customer customer1 = new Customer(1, "Jacek", "Long St. 9");

		Customer customer2 = new Customer(1, "Placek", "Short St. 9");

		Customer customer3 = new Customer(1, "Wacek", "Suitable St. 9");

		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}
}
