package com.model.boot.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.boot.rest.services.PersonalDataServices;

@RestController
@RequestMapping("/personal")
public class PeronalRestController {
	//@Autowired
	private PersonalDataServices service;
	
	//constructor injection
	public PeronalRestController(PersonalDataServices service) {
		super();
		this.service = service;
	}
	
	//@GetMapping("/age/{name}/{yob}")
	@GetMapping("/{name}/age/{yob}")
	public ResponseEntity<String> eligibilityForInsurance(@PathVariable String name, 
														  @PathVariable("yob") Integer yob){
		if(service.isValidYoB(yob)) {
			int age = service.calculateAge(yob);
			
			return new ResponseEntity<String>(String.format("Hi %s, your age is %d - Eligibile for this Insurance", name, age),HttpStatus.OK);
		}
		return new ResponseEntity<String>(String.format("Hi %s, - Not Eligibile for this Insurance", name),HttpStatus.BAD_REQUEST);
	}
}
