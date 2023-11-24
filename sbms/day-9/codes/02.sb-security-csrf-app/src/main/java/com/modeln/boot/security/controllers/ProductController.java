package com.modeln.boot.security.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.modeln.boot.security.models.Product;

@RestController
@CrossOrigin
public class ProductController {
 private Logger logger = LoggerFactory.getLogger(getClass());
 
 private static final List<Product> productsList = new ArrayList<Product>(List.of(
		 					new Product(101, "Mobile"), 
		 					new Product(102, "Computer"), 
		 					new Product(103, "Laptop")));
 
 @GetMapping("/products")
 public List<Product> getAllProducts(){  
	 	return productsList; 
 }
 
 @GetMapping("/products/{pid}")
 public Product getProductByProductId(@PathVariable Integer pid) {
   Product product = productsList.stream().filter(prod -> prod.productId().equals(pid)).findFirst().orElse(null);
   return product; 
 }

 @PostMapping("/products/new")
 public void addNewProduct(@RequestBody Product product) {
   productsList.add(product);
   logger.info("saving new product {}", product);
 }
}

