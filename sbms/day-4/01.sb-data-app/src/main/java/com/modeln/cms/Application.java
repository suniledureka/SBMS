package com.modeln.cms;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.modeln.cms.entity.Contact;
import com.modeln.cms.repository.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		System.out.println(contactRepo);
		/*
		 * ContactRepository is an interface - then how come instance 
		 * - uses Proxy Design Pattern- implementation class is being created internally
		 */
		
		/*
		//-- saving or updating a Contact to persistence store/DB Table
		Contact contact = new Contact();
		contact.setContactId(101);
		contact.setContactName("Praveen Kumar");
		contact.setContactNumber("9848586878");
		
		//contactRepo.save(contact);
		Contact savedContact = contactRepo.save(contact);
		
		System.out.println("contact saved - " + savedContact);
		*/
		
		//-- saving multiple contacts
		Contact ct1 = new Contact(102, "Pankaj", "1234567890");
		Contact ct2 = new Contact(103, "Sachin", "1234567890");
		Contact ct3 = new Contact(104, "Mark", "1234567890");
		Contact ct4 = new Contact(105, "Sujith", "1234567890");
		
		List<Contact> contacts = Arrays.asList(ct1, ct2, ct3, ct4);
		//Iterable<Contact> savedContacts = contactRepo.saveAll(contacts);
		contactRepo.saveAll(contacts);
		
		context.close();
	}

}
