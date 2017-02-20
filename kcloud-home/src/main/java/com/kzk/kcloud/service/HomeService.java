package com.kzk.kcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="kcloud-home")
public interface HomeService {
	@RequestMapping("/hello")
	String hello();
}
