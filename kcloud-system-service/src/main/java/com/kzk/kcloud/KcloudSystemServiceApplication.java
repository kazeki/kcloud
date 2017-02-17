package com.kzk.kcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * @author kazeki
 */
@SpringBootApplication
public class KcloudSystemServiceApplication {
	
	public KcloudSystemServiceApplication(){
		System.out.println("KcloudSystemServiceApplication >> Created");
	}

	@Autowired
	void setEnviroment(Environment env) {
	    System.out.println("KcloudSystemServiceApplication >> system.greeting: " 
		        + env.getProperty("system.greeting"));
	    System.out.println("KcloudSystemServiceApplication >> server.port: " 
		        + env.getProperty("server.port"));
	}
	
	public static void main(String[] args) {
		System.out.println("Before Run");
		SpringApplication.run(KcloudSystemServiceApplication.class, args);
		System.out.println("After Run");
	}
	
}
