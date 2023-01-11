package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Person;
import com.example.demo.entities.Project;
import com.example.demo.services.IPersonService;
import com.example.demo.services.IProjectService;

@RestController
public class ProjectRestController {
	
	@Autowired
	private IProjectService projectService;
	
	@Autowired
	private IPersonService personService;
	
//	@GetMapping("/persons/{personId}/projects")
//	public ResponseEntity<List<Project>> getAllProjetsByPersonneId(@PathVariable(value = "personId") long personId) {
//		personService.findById(personId).orElseThrow(
//				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + personId));
//		List<Project> projets = projectService.getProjectsByPersonId(personId);
//		return new ResponseEntity<>(projets, HttpStatus.OK);
//	}
	
	@GetMapping("/persons/{personId}/projects")
	public ResponseEntity<List<Project>> getById(@PathVariable(value = "personId") long id) {
		return personService.findById(id).map((p) -> {
			List<Project> projets = projectService.getProjectsByPersonId(p.getId());
			return new ResponseEntity<>(projets, HttpStatus.OK);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La personne avec l'id " + id + "n'existe pas"));
	}
}