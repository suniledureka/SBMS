package com.model.boot.rest.dao;

import java.util.Arrays;
import java.util.List;

import com.model.boot.rest.models.Book;

public class BooksDAO {
	public static List<Book> getLibraryStock(){
		List<Book> books = Arrays.asList(
								new Book(12121L, "Java Reference", "James Ghosling"),
								new Book(12122L, "Spring Made Easy", "Rod Johnson"),
								new Book(12123L, "Microservices - An Ultimate Guide", "Cloud")
								);
		return books;
	}
}
