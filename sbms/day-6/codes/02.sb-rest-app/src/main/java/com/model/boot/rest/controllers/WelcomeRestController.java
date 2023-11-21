package com.model.boot.rest.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {	
	
	@GetMapping("/welcome")
	public String sendWelcomeMessage_Get() {
		return "Welcome to ModelN - GET method";
	}
	
	@PostMapping("/welcome")
	public String sendWelcomeMessage_Postt() {
		return "Welcome to ModelN - POST method";
	}
	
	@PutMapping("/welcome")
	public String sendWelcomeMessage_Put() {
		return "Welcome to ModelN - PUT method";
	}
	
	@DeleteMapping("/welcome")
	public String sendWelcomeMessage_Delete() {
		return "Welcome to ModelN - Delete method";
	}
	
	@PatchMapping("/welcome")
	public String sendWelcomeMessage_Patch() {
		return "Welcome to ModelN - Patch method";
	}
}
