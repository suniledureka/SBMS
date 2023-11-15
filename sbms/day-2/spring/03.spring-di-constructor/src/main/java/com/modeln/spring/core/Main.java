package com.modeln.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modeln.spring.core.beans.Customer;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("customer-car-beans.xml");
		
		//Customer cust = context.getBean("sanjay", Customer.class);
		Customer cust = context.getBean("praveen", Customer.class);
		System.out.println(cust.getCustomerName() + ", owns a " + cust.getCar().getModel()+ " car, which costs Rs."+cust.getCar().getCost());
	}

}
