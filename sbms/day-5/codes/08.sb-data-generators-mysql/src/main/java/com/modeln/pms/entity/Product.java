package com.modeln.pms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
	//@GeneratedValue
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_generator")
	//@SequenceGenerator(name = "pid_generator", sequenceName = "prod_sequence", initialValue = 101, allocationSize = 2)
	private Long productId;
	private String productName;
	
	public Product(String productName) {
		super();
		this.productName = productName;
	}
	
	
}
