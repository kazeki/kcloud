package com.kzk.kcloud.service.fallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

import com.kzk.kcloud.model.User;
import com.kzk.kcloud.service.SystemService;

@Component
public class SystemServiceFallback implements SystemService{
	
	// 偶然发现，此处变量定义为static会导致Fallback无效，调用异常时直接把异常抛出
	@Autowired
	private CounterService counterService;
	
	@Override
	public String greet(String name) {
		System.out.println("counterService: "+counterService.hashCode() +" "+counterService);
		counterService.increment("kcloud-home.greet.failed");
		if(name!=null){
			return "Sorry, "+name+"! The call to SystemService>>greet has failed!";
		}else{
			return "Sorry! The call to SystemService>>greet has failed!";
		}
	}

	@Override
	public String greet(User user) {
		return "Sorry! The call to SystemService>>greet has failed!";
	}

}
