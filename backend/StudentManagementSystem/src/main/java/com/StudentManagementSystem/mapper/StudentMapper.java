package com.StudentManagementSystem.mapper;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.StudentManagementSystem.dto.StudentCourseDTO;
import com.StudentManagementSystem.entity.Course;
import com.StudentManagementSystem.entity.Student;

@Mapper
public interface StudentMapper {

	@Insert("insert into student(id,name,email,password) values(#{id},#{name},#{email},#{password})")
	@SelectKey(statement="SELECT LAST_INSERT_ID()",keyProperty="id",
	before=false,resultType=Integer.class)
	public boolean insertStudent(Student st);
	
	@Update("update student set name=#{name} , email=#{email} where id=#{id}")
	public boolean updateStudent(Student st);
	
	@Select("Select * from student where id=#{id}")
	public Student getByID(long id);
	
	@Select("select id,name,email from student where email=#{email} and password=#{password}")
	public Student login(String email,String password);
	
	@Select("select * from student")
	public List<Student> findAll();
	
	@Select("Select c.* from course c inner join st_course stc on c.id=stc.courseId where stc.studentId=#{stId}")
	public List<Course> getAllCoursesStEnrolled(long stId);
	
	@Select("Select c.* from course c inner join st_course stc on c.id=stc.courseId where stc.studentId not in (#{stId})")
	public List<Course> getNotEnrolledCourses(long stId);
	
	@Select("Select * from student limit #{startNumber} , 10")
	public List<Student> getPaginatedStudents(int startNumber);
	
	@Select("Select c.* from course c inner join st_course stc on c.id=stc.courseId where stc.studentId = #{stId}")
	public List<Course> getEnrolledCourses(long stId);
	
	@Select("select * from course")
	public List<Course> getAllCourses();
	
	@Insert("insert into st_course(id,studentId,courseId) values(#{id},#{studentId},#{courseId})")
	@SelectKey(statement="SELECT LAST_INSERT_ID()",keyProperty="id",
	before=false,resultType=Integer.class)
	public boolean saveStCourse(StudentCourseDTO stCourse);
	
	@Delete("delete from st_course where studentId=#{stId} and courseId=#{courseId}")
	public boolean removeCourseStudent(long stId,long courseId);
	
}
