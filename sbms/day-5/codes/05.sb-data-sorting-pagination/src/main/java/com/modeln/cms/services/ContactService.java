package com.modeln.cms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.modeln.cms.entity.Contact;
import com.modeln.cms.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepo;
	
	public void getAllContactsInAscName() {
		//List<Contact> contacts = contactRepo.findByOrderByContactNameAsc();
		//List<Contact> contacts = contactRepo.findAll(Sort.by("contactName")); 
		List<Contact> contacts = contactRepo.findAll(Sort.by("contactName").ascending()); 
		printContacts(contacts);
	}

	public void getAllContactsInDescName() {
		//List<Contact> contacts = contactRepo.findByOrderByContactNameDesc();
		List<Contact> contacts = contactRepo.findAll(Sort.by("contactName").descending()); 
		printContacts(contacts);
	}
	
	public void getContactsInPages(int pageSize) {
		int pageNo=0; //0-first page
		/*
		PageRequest pageReq = PageRequest.of(pageNo, pageSize);		
		Page<Contact> page = contactRepo.findAll(pageReq);
		List<Contact> contacts = page.getContent();
		printContacts(contacts);
		*/
		
		long totalContacts = contactRepo.count();
		//long noOfPages = Math.ceil((float)totalContacts/pageSize));
		long noOfPages = (totalContacts%pageSize == 0)?(totalContacts/pageSize):(totalContacts/pageSize)+1;
		for(int i=1; i<=noOfPages; i++) {
			PageRequest pageReq = PageRequest.of(pageNo++, pageSize);		
			Page<Contact> page = contactRepo.findAll(pageReq);
			List<Contact> contacts = page.getContent();
			System.out.printf("------------ contacts (%d / %d ) ------------\n",i,noOfPages);
			printContacts(contacts);
		}
	}
	
	private void printContacts(List<Contact> contacts) {
		contacts.forEach(System.out::println);		
	}
}
