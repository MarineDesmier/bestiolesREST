package fr.diginamic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.diginamic.dto.PersonDto;
import fr.diginamic.dto.PersonMapper;
import fr.diginamic.exception.CreateEntityWithId;
import fr.diginamic.exception.EntityNotFoundException;
import fr.diginamic.exception.UpdateEntitywithoutId;
import fr.diginamic.model.Person;
import fr.diginamic.repository.PersonRepository;
import jakarta.validation.Valid;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonMapper personMapper;
	
	public Person findById(Integer id) {
		return personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public List<PersonDto> findAll() {
		return personRepository.findAll()
				.stream()
				.map((person) -> personMapper.toPersonDto(person))
				.collect(Collectors.toList());
	}
	
	public Person update(@Valid Person updatedPerson) {
		if(updatedPerson.getId() == null) {
			throw new UpdateEntitywithoutId();
		}
		return personRepository.save(updatedPerson);
	}
	
	public Person create(@Valid Person updatedPerson) {
		if(updatedPerson.getId() != null) {
			throw new CreateEntityWithId();
		}
		return personRepository.save(updatedPerson);
	}
	
	public void deleteById(Integer id) {
		if(!personRepository.existsById(id)) {
			throw new EntityNotFoundException(); 
		}
		personRepository.deleteById(id);
	}
	
	public List<Person> search(
			String firstname,
            String lastname,
            Integer age){
		  return personRepository.testCriterias(firstname, lastname, age);
	   }
	
	public Page<Person> findAllPageable(Pageable pageable){
		  return personRepository.findAll(pageable);
	   }
}
