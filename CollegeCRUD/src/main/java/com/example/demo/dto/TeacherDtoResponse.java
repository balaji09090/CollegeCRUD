package com.example.demo.dto;

import com.example.demo.model.Teacher;







public class TeacherDtoResponse {

	private Integer id;
	private String name;
	private String email;
	private String mob;
	private String role;
	
	public TeacherDtoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeacherDtoResponse(Integer id, String name, String email, String mob, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mob = mob;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "TeacherDtoResponse [id=" + id + ", name=" + name + ", email=" + email + ", mob=" + mob + ", role="
				+ role + "]";
	}
	
	
	public static TeacherDtoResponse toDto (Teacher t) {
		TeacherDtoResponse temp = new TeacherDtoResponse();
		temp.setId(t.getId());
		temp.setName(t.getName());
		temp.setEmail(t.getEmail());
		temp.setMob(t.getMob());
		temp.setRole(t.getRole());
		return temp;
		
	}


	
}
