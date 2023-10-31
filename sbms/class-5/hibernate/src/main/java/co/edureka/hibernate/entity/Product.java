package co.edureka.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_DTLS")
public class Product {
	@Id
	@Column(name = "PROD_ID", length = 5, unique = true, nullable = false)
	//@GeneratedValue
	private Integer productId;
	
	@Column(name = "PROD_NAME")
	private String productName;
	
	@Column(name = "PROD_PRICE")
	private float productPrice=100f;

	public Integer getProductId() {
		System.out.println("inside getProductId()");
		return productId;
	}

	public void setProductId(Integer productId) {
		System.out.println("inside setProductId()");
		this.productId = productId;
	}

	public String getProductName() {
		System.out.println("inside getProductName()");
		return productName;
	}

	public void setProductName(String productName) {
		System.out.println("inside setProductName()");
		this.productName = productName;
	}

	public float getProductPrice() {
		System.out.println("inside getProductPrice()");
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		System.out.println("inside setProductPrice()");
		this.productPrice = productPrice;
	}

}
