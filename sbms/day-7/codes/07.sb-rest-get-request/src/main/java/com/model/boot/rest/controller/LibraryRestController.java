package com.model.boot.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.boot.rest.models.Book;

@RestController
@RequestMapping("/library")
public class LibraryRestController {
	@GetMapping(path = "/book",
			    produces = {"application/json", "application/xml"})
	public ResponseEntity<Book> getABook(){
		Book book = new Book();
		book.setBookId(789654L);
		book.setBookTitle("Java Complete Reference");
		book.setBookAuthor("James Ghosling");
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
}
