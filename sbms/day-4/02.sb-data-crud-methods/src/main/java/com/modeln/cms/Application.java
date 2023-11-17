package com.modeln.cms;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.modeln.cms.entity.Contact;
import com.modeln.cms.repository.ContactRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.modeln"})
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		
		//-- to get the number of contacts
		long noOfContacts = contactRepo.count();
		LOGGER.info("no of contacts = {} ", noOfContacts);
		
		//--to get a Contact based on contactId( ID property value)
		Optional<Contact> optContact = contactRepo.findById(1015);
		if(optContact.isPresent()) {
			Contact contact = optContact.get();
			LOGGER.info("{}",contact);
		}else {
			LOGGER.error("--- no matching contact found!! ---");
		}
		
		//--to get Contacts based on  multiple contactIds
		Iterable<Integer> contactIds = Arrays.asList(101,202,301,102,104);
		Iterable<Contact> contacts = contactRepo.findAllById(contactIds);
		printContacts(contacts);
		
		//--to get all contacts
		contacts = contactRepo.findAll();
		printContacts(contacts);
		
		//-- to check whether a contact is existing with a contactId or not
		int cid = 1015;
		boolean isExists = contactRepo.existsById(cid);
		LOGGER.info("Contact with Contact ID: {} - exists - {}", cid, isExists);
		//-- to delete a contact with contactId
		
		//perform all delete operations
		contactRepo.deleteById(105);
		context.close();
	}

	private static void printContacts(Iterable<Contact> contacts) {
		for(Contact ct : contacts) {
			LOGGER.info("{}", ct);
		}
		
	}

}
