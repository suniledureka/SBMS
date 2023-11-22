package com.model.boot.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.boot.rest.dao.BooksDAO;
import com.model.boot.rest.models.Book;

@RestController
@RequestMapping("/library")
public class LibraryRestController {
	List<Book> books = BooksDAO.getLibraryStock();
	
	@GetMapping(path = "/books/all",
			    produces = "application/json")
	public ResponseEntity<List<Book>> findAllBooks(){
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@GetMapping(path = "/books/search/{isbn}",
		    produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> findBookByIsbn(@PathVariable(value = "isbn", required = true) Long isbn){
		Book book = books.stream().filter(bk -> bk.getBookId().equals(isbn)).findFirst().orElse(null);
		if(book != null)
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		
		return new ResponseEntity<String>("matching book not found for ISBN: "+ isbn, HttpStatus.BAD_REQUEST);
}	
}
