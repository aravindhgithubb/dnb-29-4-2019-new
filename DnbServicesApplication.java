package com.dnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DnbServicesApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DnbServicesApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DnbServicesApplication.class, args);
	}
}
