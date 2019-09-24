package com.devaj.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.devaj.graphql.model.Employee;
import com.devaj.graphql.model.Project;
import com.devaj.graphql.repository.EmployeeRepository;
import com.devaj.graphql.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver  {

    @Autowired
    private ProjectRepository projectRepository;


    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

}
