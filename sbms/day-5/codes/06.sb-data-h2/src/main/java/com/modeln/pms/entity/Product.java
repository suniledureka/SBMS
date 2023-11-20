package com.modeln.pms.entity;

import jakarta.persistence.Entity;
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
	private Long productId;
	private String productName;
}
