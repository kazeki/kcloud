package com.kzk.kcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author kazeki
 */
@SpringBootApplication
@EnableEurekaServer
public class KcloudEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KcloudEurekaServerApplication.class, args);
	}

}
