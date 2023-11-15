package com.modeln.boot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class LauncherApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LauncherApp.class, args);
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans configured = " + noOfBeans);
		System.out.println();
		
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(beanName -> System.out.println("----> " + beanName));
		context.close();
	}

}
