package com.projectcontrolapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcontrolapi.model.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
