package com.modeln.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {
	@GetMapping(path = {"/greet", "/greetings"})
	public String sendGreetings(){
		return "Greetings from Model N";
	}
}
