package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Person;
import com.example.demo.repository.PersonRepository;

//Fichier qui mappe sur des chemins et qui va nous renvoyer
//des reponses au format JSon, XML
@RestController 
// permet la communication entre application(Banckend <==> Frontend)
@CrossOrigin("*")
public class PersonRestController {
	
	@Autowired //utiliser pour l'injection de dependances
	private PersonRepository personRepository;
	
	@GetMapping("/persons")
	public List<Person> getAll(){
		return personRepository.findAll();
	}
		
//	@PostMapping // Enregistre une donnee
//	@DeleteMapping // Supprimer une donnee
//	@PutMapping // Mettre a jour une donnee totalement
//	@PatchMapping // Mettre a jour une donne partiellement
	
	// Une api utilise les methodes du protocole HTTP (GET, POST, PUT, PATCH, DELETE)
		
	// /hello 
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	
	@PostMapping("/hello")
	public String sayHello(String msg) {
		return msg;
	}
	
	@PostMapping("/persons")
	public Person create(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@GetMapping("/persons/{id}")
	public Person getById(@PathVariable long id) {
		return personRepository.findById(id).get();
		}
	
	@PutMapping("/persons/{id}")
	public Person updatePerson(@PathVariable long id, @RequestBody Person personX) {
		
		Person person = personRepository.findById(id).get();
		
		person.setAge(personX.getAge());
		person.setFirstName(personX.getFirstName());
		person.setLastName(personX.getLastName());
		

		return personRepository.save(person);
	}
	
	@DeleteMapping("/persons/{id}")
	public void deletePerson(@PathVariable long id) {
		
		Person person = personRepository.findById(id).get();
		personRepository.delete(person);

		
	}
	
	
	
	
}