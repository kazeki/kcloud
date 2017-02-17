package com.kzk.kcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

/**
 * @author kazeki
 */
@EnableDiscoveryClient
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
		System.out.println("After Run");
	}
	
}
