package com.modeln.project;

import java.lang.reflect.Field;

import com.modeln.project.models.Product;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Product prod = new Product();
		System.out.println(prod);
		//prod.productName = "Mobile Phone"; //The field Product.productName is not visible
		
		Class<?> productClass = Class.forName("com.modeln.project.models.Product");
		
		Field productNameField =  productClass.getDeclaredField("productName");
		
		productNameField.setAccessible(true);
		
		productNameField.set(prod, "Mobile Phone");
		System.out.println(prod);
	}

}
