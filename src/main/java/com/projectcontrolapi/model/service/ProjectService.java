package com.projectcontrolapi.model.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projectcontrolapi.model.entities.Project;
import com.projectcontrolapi.model.repository.ProjectRepository;
import com.projectcontrolapi.model.service.exception.DatabaseException;
import com.projectcontrolapi.model.service.exception.ResourceNotFoundException;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	public Project findById(Long id) {
		Optional<Project> obj = projectRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public void delete(Long id) {

		try {
			projectRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Project update(Long id, Project obj) {
		try {
			Project entity = projectRepository.getOne(id);
			updateData(entity, obj);
			return projectRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Project entity, Project obj) {
		entity.setContent(obj.getContent());
		entity.setTitle(obj.getTitle());
		entity.setStatus(obj.getStatus());
		entity.setDue(obj.getDue());
		entity.setPerson(obj.getPerson());
	}

	public Project insert(Project obj) {
		return projectRepository.save(obj);
	}

}
