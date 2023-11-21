package com.model.boot.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modeln")
public class RequestDataRestController {
	@RequestMapping("/processdata")
	public ResponseEntity<?> processHeaderAndBody(@RequestHeader("Host") String host,
									@RequestHeader(value = "company", required = false, defaultValue = "NA") String company, 
									@RequestBody(required = false) String data){
		String responseText = String.format("Host = %s\nCompany = %s\nRequest Data = %s", host, company, data);
		return new ResponseEntity<String>(responseText, HttpStatus.OK);
	}
}
