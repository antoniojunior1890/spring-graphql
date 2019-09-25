package com.devaj.graphql.repository;

import com.devaj.graphql.model.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    @EntityGraph(attributePaths = {"projectList"})
    List<Employee> findAll();
}
