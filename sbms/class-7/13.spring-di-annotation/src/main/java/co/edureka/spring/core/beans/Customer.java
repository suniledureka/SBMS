package co.edureka.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Customer {
	@Value("Praveen Kumar")
	private String customerName;
	
	@Autowired
	//@Qualifier("bmw")
	private Car car;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Car getCar() {
		return car;
	}
	
	public void setCar(Car car) {
		System.out.println("inside setCar() method");
		this.car = car;
	}
	
}
