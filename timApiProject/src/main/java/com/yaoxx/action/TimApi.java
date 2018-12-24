package com.yaoxx.action;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

//@ImportResource(locations = { "classpath:jaxrs_config.xml" }) restful配置文件
//,"com.yaoxx.webService.config" soap配置类
@MapperScan({"com.yaoxx.mapper","com.yaoxx.OA.vacation.mapper"})
@ComponentScan(basePackages = { "com.yaoxx.service", 		"com.yaoxx.service.impl", 
								"com.yaoxx.controller", 	"com.yaoxx.entity",
								"com.yaoxx.base",			"com.yaoxx.OA.vacation"})
@ServletComponentScan("com.yaoxx.base") //配置
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) 
public class TimApi {
	public static void main(String[] args) {
		SpringApplication.run(TimApi.class, args);
	}
	
}
