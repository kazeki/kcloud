package com.kzk.kcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author kazeki
 */
@SpringBootApplication
@EnableConfigServer
public class KcloudConfigCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(KcloudConfigCenterApplication.class, args);
	}
}
