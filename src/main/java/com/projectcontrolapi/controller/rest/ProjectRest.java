package com.projectcontrolapi.controller.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projectcontrolapi.model.entities.Project;
import com.projectcontrolapi.model.service.ProjectService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("rest/project")
public class ProjectRest {
	
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	public ResponseEntity<List<Project>> findAll() {
		List<Project> list = projectService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Project> findById(@PathVariable Long id) {
		Project obj = projectService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Project> insert(@RequestBody Project obj) {
		obj = projectService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		projectService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody Project obj) {
		obj = projectService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
