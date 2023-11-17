package com.modeln.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PRODUCT_DTLS")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Integer produId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
		
	@Column(name = "PRODUCT_PRICE")
	private Float productPrice;
}
