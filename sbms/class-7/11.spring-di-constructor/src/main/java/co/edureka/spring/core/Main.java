package co.edureka.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edureka.spring.core.beans.Customer;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("customer-car-beans.xml");
		
		Customer praveen = (Customer)context.getBean("praveen");
		
		System.out.println(praveen.getCustomerName() + " owns a "  + praveen.getCar().getModel()+", which costs Rs."+praveen.getCar().getCost());
		
		Customer sanjay = (Customer)context.getBean("sanjay");
		
		System.out.println(sanjay.getCustomerName() + " owns a "  + sanjay.getCar().getModel()+", which costs Rs."+ sanjay.getCar().getCost());
	}

}
