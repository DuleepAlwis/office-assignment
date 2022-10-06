package com.StudentManagementSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.StudentManagementSystem.entity.Course;
import com.StudentManagementSystem.entity.Student;

@Mapper
public interface CourseMapper {

	@Insert("insert into course(id,courseName,description,author) values(#{id},#{courseName},#{description},#{author})")
	@SelectKey(statement="SELECT LAST_INSERT_ID()",keyProperty="id",
	before=false,resultType=Integer.class)
	public boolean insertCourse(Course course);
	
	@Update("update course set courseName=#{courseName} , description=#{description},author=#{author} where id=#{id}")
	public int updateCourse(Course course);
	
	@Select("Select * from course where id=#{id}")
	public Course getByID(long id);
	
	@Select("select * from course")
	public List<Course> findAll();
	
	@Select("SELECT s.* FROM student s INNER JOIN st_course stc ON s.id = stc.studentId WHERE stc.courseId = #{id}")
	public List<Student> getAllStudents(long id);
	
	@Select("Select * from course limit #{startNumber} , 10")
	public List<Course> getPaginatedCourses(int startNumber);
}
