package com.modeln.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modeln.spring.core.beans.Customer;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("customer-car-beans.xml");
		
		Customer sanjay = context.getBean("sanjay", Customer.class);
		System.out.println(sanjay.getCustomerName() + ", owns a " + sanjay.getCar().getModel()+ " car, which costs Rs."+sanjay.getCar().getCost());
	}

}
