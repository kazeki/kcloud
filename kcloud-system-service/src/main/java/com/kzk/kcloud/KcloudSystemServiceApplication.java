package com.kzk.kcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author kazeki
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories
@EnableCaching
public class KcloudSystemServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(KcloudSystemServiceApplication.class, args);
	}

}
