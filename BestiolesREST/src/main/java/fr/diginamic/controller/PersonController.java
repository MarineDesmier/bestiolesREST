package fr.diginamic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.model.Person;
import fr.diginamic.repository.PersonRepository;
import fr.diginamic.service.PersonService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("{id}") //localhost:8080/rest/person/{id}
    public Person findById(@PathVariable Integer id) {
        return personService.findById(id);
	}
	
	@PostMapping
	public Person createPerson(@RequestBody @Valid Person personToCreate) {
        return personService.create(personToCreate);
    }
	
	@PutMapping("{id}")
    public Person updatePerson(@PathVariable Integer id, @RequestBody @Valid Person personToUpdate) {
        return personService.update(personToUpdate);
    }
    
    public List<Person> findAll() {
        return personService.findAll();
    }
    
   @DeleteMapping("{id}")
   public void deletePerson(@PathVariable Integer id) {
	   personService.deleteById(id);
   }
}
