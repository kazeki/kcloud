package com.kzk.kcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kazeki
 */
//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@Controller
public class KcloudSystemServiceApplication {
	@RequestMapping("/")
    public String home() throws Exception {
		return "forward:/mappings";
    }
	public static void main(String[] args) {
		System.out.println("Before Run");
		SpringApplication.run(KcloudSystemServiceApplication.class, args);
		System.out.println("After Run");
	}
	
}
