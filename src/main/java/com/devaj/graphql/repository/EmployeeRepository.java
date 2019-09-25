package com.devaj.graphql.repository;

import com.devaj.graphql.model.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    @EntityGraph(attributePaths = {"projectList"})
    List<Employee> findAll();

    @Override
    @EntityGraph(attributePaths = {"projectList"})
    Optional<Employee> findById(Long aLong);
}
