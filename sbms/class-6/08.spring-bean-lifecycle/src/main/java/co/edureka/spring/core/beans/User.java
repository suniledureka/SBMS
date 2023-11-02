package co.edureka.spring.core.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;

public class User {
	@Value("Sunil")
	private String firstName;
	
	@Value("Joseph")
	private String lastName;

	public User() {
		System.out.println("no argument constructor");
	}

	public User(String firstName, String lastName) {
		System.out.println("2 arguments constructor");
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		System.out.println("inside getFirstName() method");
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println("inside setFirstName() method");
	}

	public String getLastName() {
		System.out.println("inside getLastName() method");
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		System.out.println("inside setLastName() method");
	}	
	
	@PostConstruct
	public void myInit1() {
		System.out.println("user-defined initialization-1\n");
	}	
	
	@PreDestroy
	public void myDestructor() {
		System.out.println("user-defined destructor");
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
