package com.model.boot.rest.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateRestController {
	//@GetMapping(value = {"/date", "/today"})
	@GetMapping(path = {"/date", "/today"})
	public ResponseEntity<String> sendTodaysDate(){
		ResponseEntity<String> responseEntity = null;
		
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
		String dtText = dtFormatter.format(dt);
		
		//responseEntity = new ResponseEntity<>(HttpStatus.OK);
		//responseEntity = new ResponseEntity<>(dtText, HttpStatus.OK);
		//responseEntity = new ResponseEntity<>(dtText, HttpStatus.CREATED);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("compnay", "ModelN Private Limited");
		responseHeaders.add("contact", "Aakansha");
		
		responseEntity = new ResponseEntity<>(dtText, responseHeaders, HttpStatus.BAD_REQUEST);
		
		return responseEntity;
	}
}
