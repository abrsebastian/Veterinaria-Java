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

// Modificar la tabla Ventas agregando medios de pago, agregar una nueva tabla llamada "Gastos fijos"
// en la que va a contener: Gasto fijo id, tipo de gasto, precio
//agregar nueva columna de comision a empleados porque van a ir comision por venta y comision por servicio
//la tabla servicios tiene que modificarse en servicios internos y externos y dependiendo que logica se haga, se agregara un dto distinto