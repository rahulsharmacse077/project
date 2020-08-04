package com.rabobank.customerstatementprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class CustomerstatementprocessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerstatementprocessorApplication.class, args);
	}

}
