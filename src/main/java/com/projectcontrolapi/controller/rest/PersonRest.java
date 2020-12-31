package com.projectcontrolapi.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectcontrolapi.model.entities.Person;
import com.projectcontrolapi.model.service.PersonService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("rest/person")
public class PersonRest {
	
	@Autowired
	private PersonService personRepository;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		List<Person> list = personRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
