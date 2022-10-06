package com.StudentManagementSystem.StudentManagementSystem;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.StudentManagementSystem.entity.Course;
import com.StudentManagementSystem.entity.Student;

@ComponentScan(basePackages = {"com.StudentManagementSystem.Controller","com.StudentManagementSystem.Service"})
@MappedTypes({Student.class,Course.class})
@MapperScan("com.StudentManagementSystem.mapper")
@SpringBootApplication
@EnableCaching
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	
	 
	


}
