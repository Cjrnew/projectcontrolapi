package com.projectcontrolapi.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectcontrolapi.model.entities.Person;
import com.projectcontrolapi.model.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person insert(Person obj) {
		return personRepository.save(obj);
	}
	
}
