package co.edureka.spring.core.beans;

public class Customer {
	private String customerName;
	private Car car;
	
	public Customer(Car car) {
		System.out.println("constructor with 1 argument");
		this.car = car;
	}

	public Customer(String customerName, Car car) {
		System.out.println("constructor with 2 arguments");
		this.customerName = customerName;
		this.car = car;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		System.out.println("inside setCustomerName method");
		this.customerName = customerName;
	}

	public Car getCar() {
		return car;
	}
}
