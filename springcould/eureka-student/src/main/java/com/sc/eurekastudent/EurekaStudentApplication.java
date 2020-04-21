package com.sc.eurekastudent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.sc.eurekastudent.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaStudentApplication.class, args);
	}

}
