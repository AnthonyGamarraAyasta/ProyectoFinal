package com.gamarraayasta.cursoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class CursoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoserviceApplication.class, args);
	}

}
