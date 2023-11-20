package com.modeln.pms;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.modeln.pms.entity.Product;
import com.modeln.pms.repositories.ProductRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Application {
	@Autowired
	private ProductRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@PostConstruct
	public void doAfterInitialization() {
		List<Product> products = Arrays.asList(new Product(101L, "Television"),
				new Product(102L, "Computer"),
				new Product(103L, "Mobile"));
		
		repo.saveAll(products);
	}
}
