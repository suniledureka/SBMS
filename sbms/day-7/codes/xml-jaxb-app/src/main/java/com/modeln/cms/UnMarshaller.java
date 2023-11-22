package com.modeln.cms;

import java.io.File;

import com.modeln.cms.models.Customer;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

public class UnMarshaller {

	public static void main(String[] args) throws Exception{
		File xmlFile = new File("target/customer.xml");

		JAXBContext context = JAXBContext.newInstance(Customer.class);
		
		Unmarshaller unMarshaller = context.createUnmarshaller();
		
		Customer customer = (Customer) unMarshaller.unmarshal(xmlFile);
		System.out.println(customer);

	}

}
