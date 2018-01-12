package com.shipt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ShiptApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		//SpringApplication.run(ShiptApplication.class, args);
		new ShiptApplication().configure(new SpringApplicationBuilder(ShiptApplication.class)).run(args); 
	}
	
}
