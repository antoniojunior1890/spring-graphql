package com.devaj.graphql.repository;

import com.devaj.graphql.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
