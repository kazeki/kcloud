package com.kzk.kcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author kazeki
 */

@EnableFeignClients
//@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
public class KcloudHomeApplication {
	
	@RequestMapping("/")
	public String home(){
		return "forward:/mappings";
	}
	
	public static void main(String[] args) {
		System.out.println("Before Run");
		SpringApplication.run(KcloudHomeApplication.class, args);
		System.out.println("After Run");
	}
	
}
