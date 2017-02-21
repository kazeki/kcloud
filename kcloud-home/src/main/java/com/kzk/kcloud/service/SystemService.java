package com.kzk.kcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kzk.kcloud.model.User;
import com.kzk.kcloud.service.fallback.SystemServiceFallback;

@FeignClient(name="kcloud-system-service",fallback=SystemServiceFallback.class)
public interface SystemService {
	//传参时必须通过@RequestParam明确指定参数名
	@RequestMapping(value="/greet",method=RequestMethod.GET)
	String greet(@RequestParam("name") String name);
	
	//如果服务端是通过@RequestBody获得参数，则这里也使用@RequestBody来声明
	@RequestMapping(value="/greet",method=RequestMethod.POST)
	String greet(@RequestBody User user);
}
