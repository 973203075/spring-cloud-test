package com.example.eurekaclient2consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClient2ConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient2ConsulApplication.class, args);
	}
}
