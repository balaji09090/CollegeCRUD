package com.example.demo.dto;

import com.example.demo.model.HoD;

public class HoDDtoRequest {

	private Integer id;
	private String name;
	private Float exp;
	private String username;
	private String password;
	private String mob;
	private String email;
	private String dept;
	private String role;
	
	public HoDDtoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoDDtoRequest(Integer id, String name, Float exp, String username, String password, String mob, String email,
			String dept, String role) {
		super();
		this.id = id;
		this.name = name;
		this.exp = exp;
		this.username = username;
		this.password = password;
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
		return "HoDDtoRequest [id=" + id + ", name=" + name + ", exp=" + exp + ", username=" + username + ", password="
				+ password + ", mob=" + mob + ", email=" + email + ", dept=" + dept + ", role=" + role + "]";
	}
	
	public static HoD toEntity (HoDDtoRequest h) {
		HoD temp = new HoD();
		temp.setId(h.getId());
		temp.setName(h.getName());
		temp.setExp(h.getExp());
		temp.setUsername(h.getName()+h.getId());
		temp.setPassword(h.getPassword());
		temp.setMob(h.getMob());
		temp.setEmail(h.getEmail());
		temp.setDept(h.getDept());
		temp.setRole("HoD");
		return temp;
		
	}
    
    
}
