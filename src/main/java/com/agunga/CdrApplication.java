package com.agunga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.agunga.*"})
public class CdrApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdrApplication.class, args);
	}
}
