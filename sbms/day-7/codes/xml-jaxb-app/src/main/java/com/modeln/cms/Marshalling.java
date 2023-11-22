package com.modeln.cms;

import java.io.File;

import com.modeln.cms.models.Customer;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class Marshalling {

	public static void main(String[] args) throws Exception {
		Customer customer = new Customer();

		customer.setCustomerId(14523);
		customer.setCustomerName("Praveen Kumar");
		customer.setCustomerEmail("praveen@gmail.com");

		// marshalling (Java object - XML)
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(customer, new File("target/customer.xml"));
	}

}
