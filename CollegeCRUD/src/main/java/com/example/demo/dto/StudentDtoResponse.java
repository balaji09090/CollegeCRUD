package com.example.demo.dto;

import com.example.demo.model.Student;


public class StudentDtoResponse {
	
	private Integer roll;
	private String name;
	private String division;
	private Integer year;
	private String email;
	private Float marks;
	private String role;
		
	
	public StudentDtoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentDtoResponse(Integer roll, String name, String division, Integer year, String email, Float marks,
			String role) {
		super();
		this.roll = roll;
		this.name = name;
		this.division = division;
		this.year = year;
		this.email = email;
		this.marks = marks;
		this.role = role;
	}
	
		
		public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getMarks() {
		return marks;
	}

	public void setMarks(Float marks) {
		this.marks = marks;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

		@Override
	public String toString() {
		return "StudentDtoResponse [roll=" + roll + ", name=" + name + ", division=" + division + ", year=" + year
				+ ", email=" + email + ", marks=" + marks + ", role=" + role + "]";
	}

		
		public static StudentDtoResponse toDto (Student s) {
		StudentDtoResponse temp = new StudentDtoResponse();
		temp.setRoll(s.getRoll());
		temp.setName(s.getName());
		temp.setDivision(s.getDivision());
		temp.setYear(s.getYear());
		temp.setEmail(s.getEmail());
		temp.setMarks(s.getMarks());
		temp.setRole(s.getRole());
		return temp;
		
	}
	
}
