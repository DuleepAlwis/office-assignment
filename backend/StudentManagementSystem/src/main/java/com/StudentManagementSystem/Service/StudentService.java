package com.StudentManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentManagementSystem.dto.CourseDTO;
import com.StudentManagementSystem.dto.StudentCourseDTO;
import com.StudentManagementSystem.dto.StudentDTO;
import com.StudentManagementSystem.entity.Course;
import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.mapper.StudentMapper;
import com.StudentManagementSystem.utility.PasswordUtility;

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

	public List<CourseDTO> getAllCoursesStEnrolled(long stId) {
		List<Course> courseEn = this.stMapper.getAllCoursesStEnrolled(stId);
		
		List<CourseDTO> courses = new ArrayList<CourseDTO>();
		
		for(Course cs:courseEn) {
			CourseDTO courseD = new CourseDTO();
			
			courseD.setId(cs.getId());
			courseD.setAuthor(cs.getAuthor());
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
	
	public List<CourseDTO> getNotEnorlledCourses(long stId){
		
		List<Course> coursesEnrolled = this.stMapper.getEnrolledCourses(stId);
		List<Course> allCourses = this.stMapper.getAllCourses();
		
		List<CourseDTO> courses = new ArrayList<CourseDTO>();
		
		boolean found = false;
		
		
		for(int i=0;i<allCourses.size();i++) {
			Course cs = allCourses.get(i);
			found = false;
			for(int j=0;j<coursesEnrolled.size();j++) {
				if(cs.getId()==coursesEnrolled.get(j).getId()) {
					found = true;
					break;
				}
			}
			
			
			
			if(found == false && cs.getDisplay()==1) {
				CourseDTO csd = new CourseDTO();
				csd.setAuthor(cs.getAuthor());
				csd.setId(cs.getId());
				csd.setCourseName(cs.getCourseName());
				csd.setDescription(cs.getDescription());
				
				courses.add(csd);
			}
			
			
		}
		return courses;
	}
	
	public boolean saveStCourse(StudentCourseDTO stCourse) {
		
		return this.stMapper.saveStCourse(stCourse);
	}
	
	public List<CourseDTO> getEnrolledCourses(long stId){
		
		List<Course> coursesE = this.stMapper.getEnrolledCourses(stId);
		
		List<CourseDTO> coursesD = new ArrayList<CourseDTO>();
		
		for(Course cs:coursesE) {
			CourseDTO csd = new CourseDTO();
			
			csd.setAuthor(cs.getAuthor());
			csd.setCourseName(cs.getCourseName());
			csd.setDescription(cs.getDescription());
			csd.setId(cs.getId());
			
			coursesD.add(csd);
		}
		
		return coursesD;
	}
	
	public boolean removeCourseStudent(long stId,long courseId) {
		
		return this.stMapper.removeCourseStudent(stId,courseId);
	}
	
	public boolean updateStudent(Student st) {
		st.setPassword(PasswordUtility.getHashPassword(st.getPassword()));
		return this.stMapper.updateStudent(st);
	}
}
