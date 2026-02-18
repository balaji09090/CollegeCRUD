package com.example.demo.dto;

import com.example.demo.model.HoD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class HoDDtoResponse {

	private Integer id;
	private String name;
	private Float exp;
	private String mob;
	private String email;
	private String dept;
	private String role;
	
	public HoDDtoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoDDtoResponse(Integer id, String name, Float exp, String mob, String email, String dept, String role) {
		super();
		this.id = id;
		this.name = name;
		this.exp = exp;
		this.mob = mob;
		this.email = email;
		this.dept = dept;
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

	public Float getExp() {
		return exp;
	}

	public void setExp(Float exp) {
		this.exp = exp;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "HoDDtoResponse [id=" + id + ", name=" + name + ", exp=" + exp + ", mob=" + mob + ", email=" + email
				+ ", dept=" + dept + ", role=" + role + "]";
	}

	public static HoDDtoResponse toDto (HoD h) {
		HoDDtoResponse temp = new HoDDtoResponse();
		temp.setId(h.getId());
		temp.setName(h.getName());
		temp.setExp(h.getExp());
		temp.setMob(h.getMob());
		temp.setEmail(h.getEmail());
		temp.setDept(h.getDept());
		temp.setRole(h.getRole());
		return temp;
		
	}
}
