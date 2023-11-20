package com.modeln.oto.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeln.oto.entities.Passport;
import com.modeln.oto.entities.Person;
import com.modeln.oto.repositories.PassportRepository;
import com.modeln.oto.repositories.PersonRepository;

@Service
public class PersonServices {
	@Autowired
	private PersonRepository personRepo;
	@Autowired
	private PassportRepository passportRepo;
	
	public void saveData() {

		Person person = new Person();
		person.setPersonName("Praveen Kumar");
		person.setPersonGender("Male");

		Passport passport = new Passport();
		passport.setPassPortNum("RS12387");
		passport.setIssuedDate(LocalDate.now());
		passport.setExpDate(LocalDate.now().plusYears(10));

		person.setPassport(passport);
		passport.setPerson(person);

		personRepo.save(person);

	}
	
	public void deleteById(int id) {
		personRepo.deleteById(id);
	}
	
	public void searchByPassPortId(int id) {
		Passport pass = passportRepo.findById(id).get();
		System.out.println(pass.getPassPortNum());
	}
}