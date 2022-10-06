package com.StudentManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentManagementSystem.dto.CourseDTO;
import com.StudentManagementSystem.dto.StudentDTO;
import com.StudentManagementSystem.entity.Course;
import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.mapper.CourseMapper;

@Service
public class CourseService {

	private CourseMapper courseMapper;
	
	
	  public CourseService(CourseMapper courseMapper) { 
		  this.courseMapper = courseMapper; 
	  }
	 
	
	public boolean insertCourse(Course course) {
		return this.courseMapper.insertCourse(course);
	}
	
	public boolean updateCourse(Course course) {
		
		return this.courseMapper.updateCourse(course)>0;
	}
	
	public CourseDTO getById(long id) {
		System.out.println("get Course "+id);
		Course cs = this.courseMapper.getByID(id);
		if(cs!=null) {
			CourseDTO csd = new CourseDTO();
			
			csd.setAuthor(cs.getAuthor());
			
			csd.setCourseName(cs.getCourseName());
			csd.setDescription(cs.getDescription());
			csd.setId(cs.getId());
			
			return csd;
		}
		
		return null;
	}
	
	public List<CourseDTO> findAll(){
		List<Course> coursesE = this.courseMapper.findAll();
		
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
	
	public List<Student> getAllStudents(long id){
		return this.courseMapper.getAllStudents(id);
	}
	
	public List<CourseDTO> getPaginatedCourses(int startNumber){
		
		List<Course> courseEntity = this.courseMapper.getPaginatedCourses(startNumber);
		
		List<CourseDTO> courses = new ArrayList<CourseDTO>();
		
		for(Course cs:courseEntity) {
			CourseDTO csd = new CourseDTO();
			csd.setAuthor(cs.getAuthor());
			csd.setCourseName(cs.getCourseName());
			csd.setDescription(cs.getDescription());
			csd.setId(cs.getId());
			
			courses.add(csd);
		}
		
		return courses;
	}
}
