package com.s2.travelmgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableEurekaClient
public class TravelApplication {
	 public static void main(String[] args) {
	  SpringApplication.run(TravelApplication.class, args);
	 }
 }