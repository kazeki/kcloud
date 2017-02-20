package com.kzk.kcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kazeki
 */
//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class KcloudSystemServiceApplication {
	@Autowired
	Environment env;
	
	@RequestMapping("/")
    public String home() throws Exception {
		if(System.currentTimeMillis()%2==0){
			throw new Exception("Error for test");
		}
        return "Hello this is KcloudSystemServiceApplication-" + env.getProperty("server.port");
    }
	
	public KcloudSystemServiceApplication(){
		System.out.println("KcloudSystemServiceApplication >> Created");
	}

//	@Autowired
//	void setEnviroment(Environment env) {
//	    System.out.println("KcloudSystemServiceApplication >> system.greeting: " 
//		        + env.getProperty("system.greeting"));
//	    System.out.println("KcloudSystemServiceApplication >> server.port: " 
//		        + env.getProperty("server.port"));
//	}
	
	public static void main(String[] args) {
		System.out.println("Before Run");
		SpringApplication.run(KcloudSystemServiceApplication.class, args);
		System.out.println("After Run");
	}
	
}
