package com.modeln.boot.beans;

import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DieselEngine implements Engine {

	public DieselEngine() {
		System.out.println("DielselEngine :: Constructor");
	}

	public boolean startEngine() {
		System.out.println("Diesel Engine Starting......");
		boolean engineStatus = new Random().nextBoolean();
		return engineStatus;
	}

}
