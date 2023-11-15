package com.modeln.spring.core.beans;

public class Customer {
	private String customerName;
	private Car car;
	
	public Customer() {
		super();
	}
	
	public Customer(Car car) {
		super();
		this.car = car;
	}

	public Customer(String customerName, Car car) {
		super();
		this.customerName = customerName;
		this.car = car;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Car getCar() {
		return car;
	}

}
