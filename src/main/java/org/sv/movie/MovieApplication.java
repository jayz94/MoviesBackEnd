package org.sv.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication (exclude= { SecurityAutoConfiguration.class })//exclude para evitar el login por cada carga
public class MovieApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

}
