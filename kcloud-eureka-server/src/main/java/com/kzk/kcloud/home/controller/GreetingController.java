package com.kzk.kcloud.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	public GreetingController(){
		System.out.println("GreetingController >> Created");
	}
	
	//通过Environment注入获取配置信息(Environment.getProperty)
//	@Autowired
	protected Environment environment;
	@Autowired
	void setEnviroment(Environment environment) {
		this.environment = environment;
	    System.out.println("GreetingController >> system.greeting: " 
		        + this.environment.getProperty("system.greeting"));
	    System.out.println("GreetingController >> server.port: " 
		        + environment.getProperty("server.port"));
	}

	//通过@Value注入获取配置信息，如果配置缺失可能导致应用启动失败
//	@Value("${system.greeting}")
	protected String greeting="Default Hello";
	
	@RequestMapping("/")
	public String greet(){
		System.out.println("GreetingController >> system.greeting: " 
		        + environment.getProperty("system.greeting"));
		System.out.println("GreetingController >> server.port: " 
		        + environment.getProperty("server.port"));
		//return greeting;
		return environment.getProperty("system.greeting");
	}
}
