package com.StudentManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagementSystem.Service.CourseService;
import com.StudentManagementSystem.dto.CourseDTO;
import com.StudentManagementSystem.entity.Course;
import com.StudentManagementSystem.entity.Student;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping(value="/course")
public class CourseController {

	@Autowired 
	CourseService courseService;
	
	@PostMapping(value="/createCourse")
	public boolean createCourse(@RequestBody CourseDTO course) {
		
		Course courseEnt = new Course();
		
		
		courseEnt.setCourseName(course.getCourseName());
		courseEnt.setDescription(course.getDescription());
		courseEnt.setAuthor(course.getAuthor());
		System.out.println(course);
		System.out.println(courseEnt);
		return this.courseService.insertCourse(courseEnt);
			
	}
	
	@PutMapping(value="/updateCourse")
    @CachePut(value="Course", key="#course.getId()")
	public boolean updateCourse(@RequestBody CourseDTO course) {
		
		Course courseEnt = new Course();
		
		courseEnt.setId(course.getId());
		
		courseEnt.setCourseName(course.getCourseName());
		courseEnt.setDescription(course.getDescription());
			courseEnt.setAuthor(course.getAuthor());
		return this.courseService.updateCourse(courseEnt);
	}
	
	@GetMapping(value="/getById/{id}")
	//@Cacheable(value = "Course",key="#id")
	public CourseDTO getById(@PathVariable("id") long id) {
		//return this.courseService.getById(id);
	
		return this.courseService.getById(id);
		
	}
	
	@GetMapping(value="/getAll")
	public List<CourseDTO> getAll(){
		return this.courseService.findAll();
	}
	
	@GetMapping(value="/getAllStudents/{courseId}")
	public List<Student> getAllStudents(@PathVariable("courseId") long courseId){
		return this.courseService.getAllStudents(courseId);
	}
	
	@GetMapping(value="/getPagination/{startNumber}")
	public List<CourseDTO> getPagination(@PathVariable int startNumber){
		
		if(startNumber>=0) {
			return this.courseService.getPaginatedCourses(startNumber);
		}
		return null;
	}
	
	@DeleteMapping(value="/deleteCourse/{csId}")
	public boolean deleteCourse(@PathVariable("csId") long csId) {
		return this.courseService.deleteCourse(csId);
	}
}
