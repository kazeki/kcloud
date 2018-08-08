package com.kzk.kcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class KcloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(KcloudGatewayApplication.class, args);
	}
}
