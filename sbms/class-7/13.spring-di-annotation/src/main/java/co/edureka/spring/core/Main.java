package co.edureka.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import co.edureka.spring.core.beans.Customer;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BusinessConfigurations.class);
		
		Customer praveen = (Customer)context.getBean(Customer.class);
		
		System.out.println(praveen.getCustomerName() + " owns a "  + praveen.getCar().getModel()+", which costs Rs."+praveen.getCar().getCost());
	}

}
