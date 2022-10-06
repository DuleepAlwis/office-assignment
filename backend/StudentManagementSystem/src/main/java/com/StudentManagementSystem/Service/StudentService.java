package com.StudentManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentManagementSystem.dto.CourseDTO;
import com.StudentManagementSystem.dto.StudentDTO;
import com.StudentManagementSystem.entity.Course;
import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.mapper.StudentMapper;

@Service
public class StudentService {

	private StudentMapper stMapper;

	//public static final String HASH_KEY = "Student";

	public StudentService(StudentMapper stMapper) {
		this.stMapper = stMapper;
	}

	public Boolean insertStudent(Student st) {
		return this.stMapper.insertStudent(st);
	}

	public Boolean updateStudent(Student st) {

		return this.stMapper.updateStudent(st);
		// System.out.println("Update student");
	}

	public StudentDTO getById(long id) {
		System.out.println("get students");

		Student st = this.stMapper.getByID(id);
		
		StudentDTO std = null;
		
		if(st!=null) {
			std = new StudentDTO();
			
			std.setEmail(st.getEmail());
			std.setId(st.getId());
			std.setName(st.getName());
		}
		
		return std;
	}

	public List<StudentDTO> findAll() {

		List<Student> studentsE = this.stMapper.findAll();

		
		  /*LinkedHashMap<Long, Student> lmap = new LinkedHashMap<Long, Student>();
		  
		  for(Student st:students) {
			  lmap.put(st.getId(), st);
		  }
		  
		  System.out.println(lmap); 
		  return lmap;*/
		 
		List<StudentDTO> studentsD = new ArrayList<StudentDTO>();
		
		for(Student st:studentsE) {
			StudentDTO std = new StudentDTO();
			std.setEmail(st.getEmail());
			
			std.setId(st.getId());
			std.setName(st.getName());
			
			studentsD.add(std);
		}
		return studentsD;
		// return (LinkedHashMap<Long, Student>) students;
	}

	public List<CourseDTO> getAllCourses(long stId) {
		List<Course> courseEn = this.stMapper.getAllCourses(stId);
		
		List<CourseDTO> courses = new ArrayList<CourseDTO>();
		
		for(Course cs:courseEn) {
			CourseDTO courseD = new CourseDTO();
			
			courseD.setId(cs.getId());
			
			courseD.setCourseName(cs.getCourseName());
			courses.add(courseD);
		}
		
		return courses;
		
	}
	
	public List<StudentDTO> getPaginatedStudents(int startNumber){
		
		List<Student> studentEntity = this.stMapper.getPaginatedStudents(startNumber);
		
		List<StudentDTO> students = new ArrayList<StudentDTO>();
		
		for(Student st:studentEntity) {
			StudentDTO std = new StudentDTO();
			std.setEmail(st.getEmail());
			std.setId(st.getId());
			std.setName(st.getName());
			
			students.add(std);
		}
		
		return students;
	}
	
	public StudentDTO login(String email,String password) {
		
		Student st = this.stMapper.login(email, password);
		StudentDTO std = null;
		if(st!=null) {
			std = new StudentDTO();
			std.setEmail(st.getEmail());
			std.setId(st.getId());
			std.setName(st.getName());
			
		}
		
		return std;
	}
}
