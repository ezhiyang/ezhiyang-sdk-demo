package com.ezhiyang.sdk.demo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 测试启动类
 * @author Theo Zhou
 *
 */
@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	
	/**
	 * redis 缓存初始化
	 */
//	@Bean
//	public AbstractAuthCache abstractAuthCache(RedisTemplate<Object, Object> redisTemplate) {
//    AbstractAuthCache cache = new RedisAuthCache(redisTemplate);
//    return cache;
//  }
	
}
