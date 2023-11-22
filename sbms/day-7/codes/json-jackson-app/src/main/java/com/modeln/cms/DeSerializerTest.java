package com.modeln.cms;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.modeln.cms.models.Customer;

public class DeSerializerTest {

	public static void main(String[] args) throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		
		File jsonFile = new File("target/customer.json");
		
		Customer cust = objMapper.readValue(jsonFile, Customer.class);
		
		System.out.println(cust);		
	}

}
