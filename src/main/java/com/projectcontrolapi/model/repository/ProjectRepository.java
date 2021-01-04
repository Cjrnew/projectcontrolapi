package com.projectcontrolapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcontrolapi.model.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
