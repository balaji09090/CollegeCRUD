package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	private Integer roll;
	private String name;
	private String division;
	private Integer year;
	private String username;
	private String password;
	private String email;
	private Float marks;
	private String role;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer roll, String name, String division, Integer year, String username, String password,
			String email, Float marks, String role) {
		super();
		this.roll = roll;
		this.name = name;
		this.division = division;
		this.year = year;
		this.username = username;
		this.password = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Student [roll=" + roll + ", name=" + name + ", division=" + division + ", year=" + year + ", username="
				+ username + ", password=" + password + ", email=" + email + ", marks=" + marks + ", role=" + role
				+ "]";
	}
	
	
	
}
