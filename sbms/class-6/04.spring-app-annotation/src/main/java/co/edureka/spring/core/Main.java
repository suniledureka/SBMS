package co.edureka.spring.core;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edureka.spring.core.beans.User;
import co.edureka.spring.core.utils.PasswordEncoder;

public class Main {

	public static void main(String[] args) {
		//-- initialize spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("--------------------------------------------------------------------------------\n");
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans configured = " + noOfBeans);
		System.out.println();
		
		String[] beanNames = context.getBeanDefinitionNames();
		System.out.println("============================ BEAN NAMES =========================");
		Arrays.stream(beanNames).forEach(beanName -> System.out.println("----------> " + beanName));
		
		System.out.println("--------------------------------------------------------------------------------\n");
		//PasswordEncoder pwd = (PasswordEncoder)context.getBean("generateEncoderObject");
		//PasswordEncoder pwd = context.getBean(PasswordEncoder.class);
		//PasswordEncoder pwd = (PasswordEncoder) context.getBean("encoder");
		PasswordEncoder pwd = (PasswordEncoder) context.getBean("security");
		
		String pass = "myPass#123";
		String encodedPass = pwd.encodePassword(pass);
		System.out.println("original password: " + pass);
		System.out.println("encoded password: " + encodedPass);
	}

}
