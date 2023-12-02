package com.modeln.students.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modeln.students.entities.Student;
import com.modeln.students.entities.Subject;

import lombok.Data;

@Data
public class StudentResponse {
	private long id;

	@JsonProperty("first_name")
	private String firstName;

	private String lastName;

	private String email;
	
	private String street;

	private String city;
	
	private List<SubjectResponse> learningSubjects;
	
	public StudentResponse (Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
		
		if (student.getLearningSubjects() != null) {
			learningSubjects = new ArrayList<SubjectResponse>();
			for (Subject subject: student.getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}
	}
}
