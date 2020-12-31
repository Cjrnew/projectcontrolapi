package com.projectcontrolapi.model.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projectcontrolapi.model.entities.Person;
import com.projectcontrolapi.model.repository.PersonRepository;
import com.projectcontrolapi.model.service.exception.DatabaseException;
import com.projectcontrolapi.model.service.exception.ResourceNotFoundException;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		Optional<Person> obj = personRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Person insert(Person obj) {
		return personRepository.save(obj);
	}
	
public void delete(Long id) {
		
		try {
			personRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Person update(Long id, Person obj) {		
		try {
			Person entity = personRepository.getOne(id);
			updateData(entity, obj);
			return personRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Person entity, Person obj) {
		entity.setName(obj.getName());
	}
	
}
