package co.edureka.spring.core;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//-- initialize spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		System.out.println("--------------------------------------------------------------------------------\n");
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans configured = " + noOfBeans);
		System.out.println();
		
		String[] beanNames = context.getBeanDefinitionNames();
		System.out.println("============================ BEAN NAMES =========================");
		Arrays.stream(beanNames).forEach(beanName -> System.out.println("----------> " + beanName));
	}

}
