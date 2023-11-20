package com.modeln.multi.db1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modeln.multi.db1.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
