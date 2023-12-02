package com.modeln.students.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentRequest {

	//@JsonProperty("first_name")
	@NotBlank(message = "First name is required")
	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private List<SubjectRequest> subjectsLearning;

}
