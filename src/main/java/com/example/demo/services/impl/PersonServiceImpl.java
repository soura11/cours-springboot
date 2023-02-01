package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.services.IPersonService;

@Service("personService")
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private PersonRepository personRepository;

	public PersonServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public List<Person> findAll() {
	 * 
	 * return personRepository.findAll(); }
	 */

	@Override
	public List<Person> findAll() {
		return personRepository.findAll().stream().filter((x) -> x.getAge() >= 18).collect(Collectors.toList());
	}

	@Override
	public Person saveOrUpdate(Person o) {
		// TODO Auto-generated method stub
		return personRepository.save(o);
	}

	@Override
	public Optional<Person> findById(long id) {
		// TODO Auto-generated method stub
		return personRepository.findById(id);
	}

	@Override
	public boolean delete(long id) {
		personRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Person> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return personRepository.findByFirstName(firstName);
	}

	@Override
	public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return personRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public List<Person> findByFirstNameContaining(String firstName) {
		// TODO Auto-generated method stub
		return personRepository.findByFirstNameContaining(firstName);
	}

	@Override
	public List<Person> chercherSelonLeNom(String lastName) {
		// TODO Auto-generated method stub
		return personRepository.chercherSelonLeNom(lastName);
	}

	@Override
	public List<Person> chercherSelonLePrenom(String firstName) {
		// TODO Auto-generated method stub
		return personRepository.chercherSelonLePrenom(firstName);
	}

}
