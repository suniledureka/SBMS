package com.modeln.boot.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine {

	public PetrolEngine() {
		System.out.println("PetrolEngine :: Constructor");
	}

	public boolean startEngine() {
		System.out.println("Petrol Engine Starting......");
		boolean engineStatus = new Random().nextBoolean();
		return engineStatus;
	}

}
