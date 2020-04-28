package com.sc.springceureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringcEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcEurekaApplication.class, args);
	}

}
