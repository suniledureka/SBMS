package com.modeln.pms.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "PRODUCT_DTLS")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
	@Id	
	@GeneratedValue(generator = "pid_generator")
	@GenericGenerator(name = "pid_generator", strategy = "com.modeln.pms.repositories.generators.ProductIdGenerator")
	private String productId;
	private String productName;
	
	public Product(String productName) {
		super();
		this.productName = productName;
	}
	
	
}
