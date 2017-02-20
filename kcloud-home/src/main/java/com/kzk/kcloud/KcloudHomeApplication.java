package com.kzk.kcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;


/**
 * @author kazeki
 */

@EnableFeignClients
//@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
public class KcloudHomeApplication {
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
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
