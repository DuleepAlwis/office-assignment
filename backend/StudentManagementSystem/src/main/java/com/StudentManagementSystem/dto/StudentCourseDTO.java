package com.StudentManagementSystem.dto;

public class StudentCourseDTO {

	private long studentId;
	private long courseId;
	private long id;
	
	public StudentCourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentCourseDTO(long studentId, long courseId, long id) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.id = id;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "StudentCourseDTO [studentId=" + studentId + ", courseId=" + courseId + ", id=" + id + "]";
	}
	
	
}
