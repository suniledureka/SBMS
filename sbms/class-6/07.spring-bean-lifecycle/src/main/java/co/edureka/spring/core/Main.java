package co.edureka.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.edureka.spring.core.beans.AppConfig;
import co.edureka.spring.core.beans.User;

public class Main {

	public static void main(String[] args) {
		//-- initialize spring container
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("--------------------------------------------------------------------------------");	
		
		//context.close(); //The method close() is undefined for the type ApplicationContext
		//((ConfigurableApplicationContext)context).close();
		
		User usr = (User) context.getBean("user");
		System.out.println(usr);
		
		((AbstractApplicationContext)context).registerShutdownHook();
	}

}
