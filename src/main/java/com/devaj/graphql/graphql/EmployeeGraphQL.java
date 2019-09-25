package com.devaj.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.devaj.graphql.dto.EmployeeSavedto;
import com.devaj.graphql.model.Employee;
import com.devaj.graphql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(EmployeeSavedto employeeSavedto) {
        return employeeRepository.save(employeeSavedto.transformToEmployee());
    }
}
