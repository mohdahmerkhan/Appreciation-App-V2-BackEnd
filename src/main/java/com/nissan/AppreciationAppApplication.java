package com.nissan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppreciationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppreciationAppApplication.class, args);
		System.out.println("Running Aprreciation App - REST API");
	}

}
