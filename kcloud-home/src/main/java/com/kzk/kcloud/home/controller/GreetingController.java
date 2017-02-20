package com.kzk.kcloud.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kzk.kcloud.service.HomeService;
import com.kzk.kcloud.service.SystemService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class GreetingController {
	@Autowired
	private EurekaClient discoveryClient;
	
	@Autowired
	private SystemService systemService;
	
	@RequestMapping("/serviceUrl")
	public String serviceUrl(String serviceKey) {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka(serviceKey, false);
	    return instance.getHomePageUrl();
	}
	
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
		String a = " AAA";
		a = systemService.hello();
		String b = " BBB";
		b = homeService.hello();
		//return greeting;
		return environment.getProperty("system.greeting") + a + b;
	}
	
	@RequestMapping("/hello2")
	public String hello2(){
		String a = "";
		a = systemService.hello("HUHUHU");
		String b = "";
		b = homeService.hello();
		return a + b;
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return " >>> Hello From Home";
	}
	
	@Autowired
	private HomeService homeService;
	
	
	
	
}
