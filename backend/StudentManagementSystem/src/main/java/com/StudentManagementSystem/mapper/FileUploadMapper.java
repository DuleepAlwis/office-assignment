package com.StudentManagementSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.StudentManagementSystem.entity.CourseContent;

@Mapper
public interface FileUploadMapper {
	
	@Insert("insert into course_content(id,fileName,location,courseId) values(#{id},#{fileName},#{location},#{courseId})")
	@SelectKey(statement="SELECT LAST_INSERT_ID()",keyProperty="id",
	before=false,resultType=Integer.class)
	public boolean saveFilePath(CourseContent cs);
	
	@Select("Select * from course_content where courseId=#{csId}")
	public List<CourseContent> getFilesByCourseID(long id);
	
	@Select("Select * from course_content where id=#{fileId}")
	public CourseContent getFileById(long fileId);
	
	@Delete("Delete from course_content where id=#{fileId}")
	public Boolean removeFile(long fileId);
}
