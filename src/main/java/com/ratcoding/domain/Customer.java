package com.ratcoding.domain;

public class Customer {

	private Integer userId;
	private String name;
	private String address;
	private long numerOfOrders;

	public Customer(Integer userId, String name, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getNumerOfOrders() {
		return numerOfOrders;
	}

	public void setNumerOfOrders(long numerOfOrders) {
		this.numerOfOrders = numerOfOrders;
	}

}
