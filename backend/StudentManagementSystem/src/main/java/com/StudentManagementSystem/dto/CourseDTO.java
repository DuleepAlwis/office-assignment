package com.StudentManagementSystem.dto;

import java.io.Serializable;

public class CourseDTO implements Serializable{

	private long id;
	private String courseName;
	private String description;
	private String author;
	
	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CourseDTO(long id, String courseName, String description, String author) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.description = description;
		this.author = author;
		
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	
	


	@Override
	public String toString() {
		return "CourseDTO [id=" + id + ", courseName=" + courseName + ", description=" + description + ", author="
				+ author +"]";
	}

	
	
	
	
	
}
