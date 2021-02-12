package com.solucionOperaQuasar.utilities;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigUtil {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.solucionOperaQuasar.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(getApiInfo());

	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Aplicación para Mercado Libre, challenge Fuego de Quasar",
				"Programa en Spring Boot que retorna\r\n"
				+ "la fuente y contenido del mensaje de auxilio",
				"Tecnologías: Java Spring Boot, Maven, Jpa, JUnit Test, POSTGRETS, Swagger", "",
				new Contact("Elkin Garzon", "https://www.linkedin.com/in/elkin-garzòn-3a871756",
						"eagarzon9@gmail.com"),
				"", "", Collections.emptyList());
	}

}
