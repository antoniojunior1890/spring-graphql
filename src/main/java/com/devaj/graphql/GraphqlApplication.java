package com.devaj.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GraphqlApplication {

	@GetMapping("/")
	public String getMessage(){
		return "Ola spring boot graphql..";
	}

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

}
