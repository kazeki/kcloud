package com.kzk.kcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author kazeki
 */
@SpringBootApplication
@EnableEurekaClient
public class KcloudSystemServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(KcloudSystemServiceApplication.class, args);
	}

}
