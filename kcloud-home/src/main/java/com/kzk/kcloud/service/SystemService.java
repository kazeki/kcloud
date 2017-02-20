package com.kzk.kcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kzk.kcloud.service.fallback.SystemServiceFallback;

@FeignClient(name="kcloud-system-service",fallback=SystemServiceFallback.class)
public interface SystemService {
	@RequestMapping("/")
	String hello();
	@RequestMapping("/")
	String hello(String msg);
}
