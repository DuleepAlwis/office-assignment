package com.StudentManagementSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.StudentManagementSystem.entity.Course;
import com.StudentManagementSystem.entity.Student;

@Mapper
public interface CourseMapper {

	@Insert("insert into course(id,courseName,description,author,display) values(#{id},#{courseName},#{description},#{author},1)")
	@SelectKey(statement="SELECT LAST_INSERT_ID()",keyProperty="id",
	before=false,resultType=Integer.class)
	public boolean insertCourse(Course course);
	
	@Update("update course set courseName=#{courseName} , description=#{description},author=#{author} where id=#{id}")
	public int updateCourse(Course course);
	
	@Select("Select * from course where id=#{id} and display=1")
	public Course getByID(long id);
	
	@Select("select * from course where display = 1")
	public List<Course> findAll();
	
	@Select("SELECT s.* FROM student s INNER JOIN st_course stc ON s.id = stc.studentId WHERE stc.courseId = #{id}")
	public List<Student> getAllStudents(long id);
	
	@Select("Select * from course where display = 1 limit #{startNumber} , 10")
	public List<Course> getPaginatedCourses(int startNumber);
	
	@Delete("delete from st_course where courseId=#{csId}")
	public boolean deleteCoursefromStCourse(long csId);
	
	@Update("update course set display=0 where id=#{csId}")
	public boolean deleteCourse(long csId);
}
