package com.modeln.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.modeln.cms.services.ContactService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		ContactService service = context.getBean(ContactService.class);
		
		System.out.println("---- contacts in Ascending order of Contact Name ------");
		service.getAllContactsInAscName();
		System.out.println();
		
		System.out.println("---- contacts in Descending order of Contact Name ------");		
		service.getAllContactsInDescName();
		System.out.println();
		
		System.out.println("----- contacts in pagination -------------");
		service.getContactsInPages(4);
	}

}
