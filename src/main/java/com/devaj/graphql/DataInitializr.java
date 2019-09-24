package com.devaj.graphql;

import com.devaj.graphql.model.Employee;
import com.devaj.graphql.model.Project;
import com.devaj.graphql.repository.EmployeeRepository;
import com.devaj.graphql.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<Employee> employees = employeeRepository.findAll();

        if(employees.isEmpty()){
            this.createEmployee("Antonio", 26, LocalDate.now());
            this.createEmployee("Junior", 65, LocalDate.now());
        }
    }

    public void createEmployee(String name, Integer age, LocalDate birth){

        Employee employee = new Employee(name, age, birth);

        employeeRepository.save(employee);

        Random gerador = new Random();

        Project project =  new Project();
        project.setName("Projeto "+ gerador.nextInt(5));
        project.setServiceCode(gerador.nextInt(5));
        project.setResponsible("Responsible "+ gerador.nextInt(5));
        project.setDeadline(LocalDate.now());
        project.setEmployee(employee);

        projectRepository.save(project);

    }

}
