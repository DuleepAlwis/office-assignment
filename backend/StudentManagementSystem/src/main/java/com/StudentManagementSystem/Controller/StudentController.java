package com.StudentManagementSystem.Controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagementSystem.Service.StudentService;
import com.StudentManagementSystem.dto.CourseDTO;
import com.StudentManagementSystem.dto.StudentDTO;
import com.StudentManagementSystem.entity.Course;
import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.utility.PasswordUtility;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	StudentService stService;
	
	@PostMapping(value="/createStudent")
	public Boolean createStudent(@RequestBody StudentDTO st) {
		Student stEntity = new Student();
		
		
		if( st!=null) {
			stEntity.setEmail(st.getEmail());
			stEntity.setName(st.getName());
			stEntity.setPassword(PasswordUtility.getHashPassword(st.getPassword()));
			return stService.insertStudent(stEntity);
			
		};
		
		return false;
		
	}
	
	@PutMapping(value="/updateStudent")
    @CachePut(value="Student", key="#st.getId()")
	public StudentDTO updateStudent(@RequestBody StudentDTO st) {
		
		
		 if(st!=null) {
			 Student stEntity = new Student();
				stEntity.setEmail(st.getEmail());
				stEntity.setId(st.getId());
				stEntity.setName(st.getName());
				if( this.stService.updateStudent(stEntity)) {
					return st;
				}
		 }
		 return null;
	}
	
	
	@GetMapping(value="/getAll")
	//@Cacheable(value = "Student")
	public List<StudentDTO> getAll(){
		return stService.findAll();
	}
	
	@GetMapping(value="getPagination/{startNumber}")
	public List<StudentDTO> getPagination(@PathVariable int startNumber){
		
		if(startNumber>=0) {
			return this.stService.getPaginatedStudents(startNumber);
		}
		return null;
	}
	
	@GetMapping(value="/getById/{id}")
	@Cacheable(value = "Student",key="#id")
	public StudentDTO getById(@PathVariable("id") long id) {

		return stService.getById(id);
	}
	
	
	@GetMapping(value="/getAllCourses/{studentId}")
	public List<CourseDTO> getAllCourses(@PathVariable("studentId") long studentId){
		return this.stService.getAllCourses(studentId);
	}
	
	@GetMapping(value="/login/{email}/{password}")
	public StudentDTO login(@PathVariable("email") String email,@PathVariable("password") String password) {
		
		
		StudentDTO st = this.stService.login(email, PasswordUtility.getHashPassword(password));
		
		return st;
	}
}
