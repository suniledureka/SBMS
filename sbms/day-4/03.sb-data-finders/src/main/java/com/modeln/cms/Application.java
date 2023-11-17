package com.modeln.cms;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.modeln.cms.entity.Contact;
import com.modeln.cms.repository.ContactRepository;

@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		
		/*-- get a contact based on a property other than ID property --*/
		//-- get a contact based on Contact Name
		Optional<Contact> optContact =  contactRepo.findByContactName("Pankajj");
		if(optContact.isPresent()) {
			Contact contact = optContact.get();
			LOGGER.info("{}",contact);
		}else {
			LOGGER.error("--- no matching contact found!! ---");
		}
		
		//-- get a contact based on Contact Number
		List<Contact> contacts = contactRepo.findByContactNumber("1234567890");
		printContacts(contacts);
		
		//-- get a contact based on Contact Number & contactName
		Contact contact = contactRepo.findByContactNameAndContactNumber("Praveen Kumar","984858687");
		if(contact != null)
			LOGGER.info("{}", contact);
		else
			LOGGER.error("-- no matching contact --");
		
		
		//-- get all the contact names using HQL /SQL
		List<String> contactNames = contactRepo.findAllContactNames();
		contactNames.stream().forEach(System.out::println);
		
		//-- get all contact names starting with something
		contactNames = contactRepo.findNamesWith("P");
		contactNames.stream().forEach(System.out::println);
	}

	private static void printContacts(Iterable<Contact> contacts) {
		for(Contact ct : contacts) {
			LOGGER.info("{}", ct);
		}
		
	}
}
