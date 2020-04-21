package com.sc.eurekagetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EurekaGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaGetwayApplication.class, args);
	}

}
