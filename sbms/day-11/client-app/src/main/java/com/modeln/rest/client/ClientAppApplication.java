package com.modeln.rest.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
		
		String endpointUrl = "http://localhost:5000/modeln/welcome";
		
		RestTemplate restTemp = new RestTemplate();
		
		ResponseEntity<String> responseEntity = restTemp.getForEntity(endpointUrl, String.class);
		
		System.out.println("Response Status Code = "+ responseEntity.getStatusCodeValue());
		
		String product = responseEntity.getBody();
		System.out.println(product);		
	}

}
