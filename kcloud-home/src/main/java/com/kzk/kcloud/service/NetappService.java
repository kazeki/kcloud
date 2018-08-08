package com.kzk.kcloud.service;

import com.kzk.kcloud.model.User;
import com.kzk.kcloud.service.fallback.SystemServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="netapp",fallback=SystemServiceFallback.class)
public interface NetappService {
	//传参时必须通过@RequestParam明确指定参数名
	@RequestMapping(value="/greet",method=RequestMethod.GET)
	String greet(@RequestParam("name") String name);
}
