package com.kzk.kcloud.home.controller;

import com.kzk.kcloud.service.NetappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kzk.kcloud.model.User;
import com.kzk.kcloud.service.SystemService;

@RestController
public class GreetingController {

	@Autowired
	private SystemService systemService;
	@Autowired
	private NetappService netappService;

	public GreetingController(){
		System.out.println("GreetingController >> Created");
	}

	//通过Environment注入获取配置信息(Environment.getProperty)
//	@Autowired
	protected Environment environment;
	@Autowired
	void setEnviroment(Environment environment) {
		this.environment = environment;
	}

	//通过@Value注入获取配置信息，如果配置缺失可能导致应用启动失败
//	@Value("${system.greeting}")
	protected String greeting="Default Hello";

	@RequestMapping(value="/greet",method=RequestMethod.GET)
	public String greet(String name){
		return systemService.greet(name);
	}

	@RequestMapping(value="/greet2",method=RequestMethod.GET)
	public String greet(@RequestParam("name") String name, @RequestParam("from") String from){
		User user = new User();
		user.setName(name);
		user.setFrom(from);
		System.out.println("greet(String name, String from)");
		return systemService.greet(user);
	}

	@RequestMapping(value="/netappgreet",method=RequestMethod.GET)
	public String netappgreet(String name){
		return netappService.greet(name);
	}

}
