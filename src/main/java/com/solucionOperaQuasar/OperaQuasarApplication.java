package com.solucionOperaQuasar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Elkin Garzón
 * Clase Main de implementación SpringBoot
 */
@SpringBootApplication
@EnableCaching
public class OperaQuasarApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperaQuasarApplication.class, args);

	}

}
