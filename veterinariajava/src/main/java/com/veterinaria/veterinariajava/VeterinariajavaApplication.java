package com.veterinaria.veterinariajava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@ComponentScan(basePackages = "com.veterinaria.veterinariajava")
public class VeterinariajavaApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("SPRING_SECURITY_USERNAME", dotenv.get("SPRING_SECURITY_USERNAME"));
        System.setProperty("SPRING_SECURITY_PASSWORD", dotenv.get("SPRING_SECURITY_PASSWORD"));

        SpringApplication.run(VeterinariajavaApplication.class, args);
	}

}
