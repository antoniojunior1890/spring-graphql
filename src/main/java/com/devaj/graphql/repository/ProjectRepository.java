package com.devaj.graphql.repository;

import com.devaj.graphql.model.Project;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

//    @EntityGraph(attributePaths = {"employee.projectList"})
    List<Project> findByEmployeeId(Long id);
}
