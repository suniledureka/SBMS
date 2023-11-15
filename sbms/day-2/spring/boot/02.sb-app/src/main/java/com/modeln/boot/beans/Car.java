package com.modeln.boot.beans;

import org.springframework.stereotype.Component;

//@Component
//@Component("mycar")
@Component(value = "mycar")
public class Car {

	public Car() {
		System.out.println("Car :: Constructor");
	}
	
	public void startJourney() {
		System.out.println("###---- HAPPY JOURNEY ----####");
	}
}
