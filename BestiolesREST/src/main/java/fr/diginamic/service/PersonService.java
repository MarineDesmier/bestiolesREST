package fr.diginamic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.diginamic.model.Person;
import fr.diginamic.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	public Person findById(Integer id) {
		return personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person update(@Valid Person updatedPerson) {
//		if(updatedPerson.getId() == null) {
//			throw Exception;
//		}
		return personRepository.save(updatedPerson);
	}
	
	public Person create(@Valid Person updatedPerson) {
		return personRepository.save(updatedPerson);
	}
	
	public void deleteById(Integer id) {
		personRepository.deleteById(id);
	}
	
}
