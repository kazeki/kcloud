package com.kzk.kcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kzk.kcloud.model.User;

@RestController
public class GreetingService {
	@Autowired
	private Environment env;

	@Autowired
	private CounterService counterService;

	@RequestMapping(value="/greet",method=RequestMethod.GET)
    public String greet(@RequestParam(defaultValue="",required=false) String name) throws Exception {
		//TODO:无论counterService.increment多少次，/metric中永远是1？需要查明原因
		counterService.increment("greet.access.total");
		//模拟故障
//		if(System.currentTimeMillis()%2==0){
//			counterService.increment("greet.access.failed");
//			throw new Exception("Error for test");
//		}
		counterService.increment("greet.access.success");
        return "Hello "+name+"! This is kcloud-system-service-" + env.getProperty("server.port");
    }

	@RequestMapping(value="/greet",method=RequestMethod.POST)
    public String greet(@RequestBody User user) throws Exception {
		System.out.println("greet(@RequestBody User user)");
        return "Hello "+user.getName()+"come from "+user.getFrom()+"! This is kcloud-system-service-" + env.getProperty("server.port");
    }

}
