package com.StudentManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class AppConfig {
 
	/*@Bean
	public JedisConnectionFactory redisConnectionFactory() {
	    JedisConnectionFactory factory = new JedisConnectionFactory();
	    factory.setHostName("localhost");
	    factory.setPort(6379);
	    factory.setUsePool(true);

	    return factory;
	}

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory cf) {
	    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
	    redisTemplate.setDefaultSerializer(new StringRedisSerializer());
	    redisTemplate.setConnectionFactory(cf);

	    return redisTemplate;
	}*/
}
