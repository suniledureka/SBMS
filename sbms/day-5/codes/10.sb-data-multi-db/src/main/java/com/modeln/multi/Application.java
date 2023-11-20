package com.modeln.multi;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.modeln.multi.db1.entities.Book;
import com.modeln.multi.db1.repositories.BookRepository;
import com.modeln.multi.db2.entities.User;
import com.modeln.multi.db2.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Application {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void addDataToDB() {
		userRepository.saveAll(Stream.of(new User(101, "Sanjay"), new User(102, "Praveen")).collect(Collectors.toList()));
		bookRepository.saveAll(Stream.of(new Book(111, "Core Java"), new Book(112, "Spring Boot")).collect(Collectors.toList()));		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);	
	}

}
