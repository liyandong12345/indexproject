package com.sc.springcreartube;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.sc.springcreartube.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class SpringcReartubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcReartubeApplication.class, args);
	}

}
