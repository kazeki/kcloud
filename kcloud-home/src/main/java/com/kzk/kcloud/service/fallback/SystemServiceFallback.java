package com.kzk.kcloud.service.fallback;

import org.springframework.stereotype.Component;

import com.kzk.kcloud.service.SystemService;

@Component
public class SystemServiceFallback implements SystemService{

	@Override
	public String hello() {
		System.out.println("call SystemService.hello Failed!");
		return "call SystemService.hello Failed!";
	}

	@Override
	public String hello(String msg) {
		System.out.println("call SystemService.hello Failed! " + msg);
		return "call SystemService.hello Failed! " + msg;
	}

}
