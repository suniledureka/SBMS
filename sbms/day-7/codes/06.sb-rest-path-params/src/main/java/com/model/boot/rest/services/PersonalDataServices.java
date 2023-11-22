package com.model.boot.rest.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class PersonalDataServices {
	
	public boolean isValidYoB(int yob) {
		return currentYear() >= yob;
	}
	
	private Integer currentYear() {
		LocalDate ld = LocalDate.now();
		return ld.getYear();
	}
	
	public Integer calculateAge(int yob) {
		return currentYear() - yob;
	}
}
