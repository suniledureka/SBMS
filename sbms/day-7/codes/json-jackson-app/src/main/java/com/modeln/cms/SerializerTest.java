package com.modeln.cms;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.modeln.cms.models.Customer;

public class SerializerTest {

	public static void main(String[] args) throws IOException {
		Customer customer = new Customer();

		customer.setCustomerId(857496);
		customer.setCustomerName("Sanjay Patil");
		customer.setCustomerEmail("sanjay@gmail.com");

		System.out.println(customer);

		ObjectMapper objMapper = new ObjectMapper();

		// --convert customer object to JSON String
		String customerJson = objMapper.writeValueAsString(customer);
		System.out.println(customerJson);
		System.out.println();

		customerJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
		System.out.println(customerJson);

		// objMapper.writeValue(new File("target/customer.json"), customer);
		objMapper.writerWithDefaultPrettyPrinter()
				 .writeValue(new File("target/customer.json"), customer);
		
		UUID uuid = UUID.randomUUID();
		String data = uuid.toString().replace("-", "").toUpperCase().substring(0,6);
		System.out.println(data);
	}

}
