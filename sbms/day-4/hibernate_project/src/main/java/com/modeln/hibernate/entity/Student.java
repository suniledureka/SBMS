package com.modeln.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
	private Integer studentId;
	private String studentName;
	private String studentEmail;
	
	public Student(String studentName, String studentEmail) {
		super();
		this.studentName = studentName;
		this.studentEmail = studentEmail;
	}

	@Override
	public String toString() {
		return String.format("Student [%-3d | %-20s | %-30s]", studentId, studentName, studentEmail);
	}
	
	
}
