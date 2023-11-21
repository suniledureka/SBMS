package com.model.boot.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cibil")
public class CibilRestController {
	@GetMapping("/score")
	public ResponseEntity<String> generateCibilScore(@RequestParam String name, @RequestParam(value = "pan", required=false) String pan){
		String responseText = "Please provide valid PAN";
		HttpStatus responseStatus = HttpStatus.BAD_REQUEST;
		
		if(pan != null && pan.length()==10) {
			responseText = String.format("Hi %s, you CIBIL Score is 785", name);
			responseStatus = HttpStatus.OK;
		}
		
		return new ResponseEntity<String>(responseText, responseStatus);
	}
}
