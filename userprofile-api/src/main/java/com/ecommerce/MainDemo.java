package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ecommerce.entity")
public class MainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MainDemo.class,args);
		
	}

}
