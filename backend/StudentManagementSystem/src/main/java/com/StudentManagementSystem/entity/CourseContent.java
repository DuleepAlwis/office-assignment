package com.StudentManagementSystem.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("CourseContent")
public class CourseContent implements Serializable {

	private long id;
	private String fileName;
	private String location;
	private long courseId;
	private LocalDate date;
	
	public CourseContent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseContent(long id, String fileName, String location, long courseId,LocalDate date) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.location = location;
		this.courseId = courseId;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	
	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CourseContent [id=" + id + ", fileName=" + fileName + ", location=" + location + ", courseId="
				+ courseId + ",date="+date+"]";
	}
	
	
}
