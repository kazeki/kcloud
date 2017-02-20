package com.kzk.kcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;

import com.netflix.discovery.shared.Application;

/**
 * @author kazeki
 */
@SpringBootApplication
@EnableEurekaServer
public class KcloudEurekaServerApplication {
	
	public KcloudEurekaServerApplication(){
		System.out.println("KcloudEurekaServerApplication >> Created");
	}

	@Autowired
	void setEnviroment(Environment env) {
	    System.out.println("KcloudEurekaServerApplication >> system.greeting: " 
		        + env.getProperty("system.greeting"));
	    System.out.println("KcloudEurekaServerApplication >> server.port: " 
		        + env.getProperty("server.port"));
	}
	
	public static void main(String[] args) {
		System.out.println("Before Run");
		SpringApplication.run(KcloudEurekaServerApplication.class, args);
		//以下启动方式参见 https://springcloud.cc/spring-cloud-netflix-zhcn.html#spring-cloud-eureka-server
		//但是按这种方式启动报错，于是改为常见的启动方式，似乎也没什么问题，Web主页可以打开
		//new SpringApplicationBuilder(Application.class).web(true).run(args);
		System.out.println("After Run");
	}
	
}
