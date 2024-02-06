package com.acorn.flower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value="classpath:custom.properties")
@SpringBootApplication
public class FlowerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FlowerApplication.class, args);
	}

}
