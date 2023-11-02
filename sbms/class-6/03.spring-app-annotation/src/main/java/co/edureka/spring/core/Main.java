package co.edureka.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edureka.spring.core.beans.User;

public class Main {

	public static void main(String[] args) {
		//-- initialize spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		System.out.println("--------------------------------------------------------------------------------\n");
		
		User usr1 = context.getBean(User.class);
		System.out.println(usr1);
		System.out.println("--------------------------------------------------------------------------------\n");
		
		User usr2 = context.getBean(User.class);
		System.out.println(usr2);
		System.out.println("--------------------------------------------------------------------------------\n");		
		
		User usr3 = (User) context.getBean("user");		
		System.out.println(usr3);		
		usr3.setFirstName("Hasan");
		System.out.println(usr3);
		System.out.println("--------------------------------------------------------------------------------\n");
	}

}
