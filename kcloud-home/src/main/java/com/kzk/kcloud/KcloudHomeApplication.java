package com.kzk.kcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * @author kazeki
 */
@SpringBootApplication
public class KcloudHomeApplication {
	
	public KcloudHomeApplication(){
		System.out.println("KcloudHomeApplication >> Created");
	}

	@Autowired
	void setEnviroment(Environment env) {
	    System.out.println("KcloudHomeApplication >> system.greeting: " 
		        + env.getProperty("system.greeting"));
	    System.out.println("KcloudHomeApplication >> server.port: " 
		        + env.getProperty("server.port"));
	}
	
	public static void main(String[] args) {
		System.out.println("Before Run");
		SpringApplication.run(KcloudHomeApplication.class, args);
		System.out.println("After Run");
	}
	
}
