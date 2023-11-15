package com.modeln.spring.core;

import java.beans.beancontext.BeanContextServices;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.modeln.spring.core.beans.BusinessConfigurations;
import com.modeln.spring.core.beans.services.BusinessServices;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BusinessConfigurations.class);
		
		System.out.println("no of beans configued = " + context.getBeanDefinitionCount()+"\n");
		
		String[] beanNames = context.getBeanDefinitionNames();
		System.out.println("======== BEAN NAMES ===========");
		
		Arrays.stream(beanNames).forEach(beanName -> System.out.println("-------> "+beanName));
		System.out.println();
		
		BusinessServices service = context.getBean(BusinessServices.class);
		System.out.println(service);
	}

}
