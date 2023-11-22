package com.model.boot.rest.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Book {
	private Long bookId;
	private String bookTitle;
	private String bookAuthor;
}
