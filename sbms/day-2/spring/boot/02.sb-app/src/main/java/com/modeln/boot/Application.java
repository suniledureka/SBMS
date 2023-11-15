package com.modeln.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.modeln.boot.beans.Car;
import com.modeln.boot.utils.EncoderDecoderUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans configured = " + noOfBeans);
		System.out.println();
		
		String[] beanNames = context.getBeanDefinitionNames();
		//Arrays.stream(beanNames).forEach(beanName -> System.out.println("----> " + beanName));
		
		//Car car = context.getBean(Car.class);
		//Car car = (Car)context.getBean("car");
		//Car car = context.getBean("car", Car.class);
		Car car = context.getBean("mycar", Car.class);
		car.startJourney();
		System.out.println();
		
		//EncoderDecoderUtils utils = context.getBean(EncoderDecoderUtils.class);
		//EncoderDecoderUtils utils = (EncoderDecoderUtils) context.getBean("generateEncoder");
		//EncoderDecoderUtils utils = (EncoderDecoderUtils) context.getBean("security");
		EncoderDecoderUtils utils = (EncoderDecoderUtils) context.getBean("encoder");
		String pass = "mypassword";
		String encodedPass = utils.encodeData(pass);
		System.out.println(encodedPass);
		context.close();
	}

}
