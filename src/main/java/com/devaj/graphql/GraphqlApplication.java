package com.devaj.graphql;

import com.devaj.graphql.model.Employee;
import com.devaj.graphql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class GraphqlApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/")
	public List<Employee> getMessage(){
		return employeeRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

//	@Bean
//	public Query query(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
//		return new Query(employeeRepository, projectRepository);
//	}
//
//	@Bean
//	public Mutation mutation(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
//		return new Mutation(employeeRepository, projectRepository);
//	}

}
