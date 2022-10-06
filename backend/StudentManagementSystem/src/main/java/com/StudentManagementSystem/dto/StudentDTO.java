package com.StudentManagementSystem.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable{

	private long id;
	private String name;
	private String email;
	private String password; 
	
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(long id, String name, String email,String admissionNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
	
}
