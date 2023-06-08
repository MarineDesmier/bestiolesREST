package fr.diginamic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.dto.PersonDto;
import fr.diginamic.exception.EntityNotFoundException;
import fr.diginamic.model.Person;
import fr.diginamic.service.PersonService;
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
	
	/**
	 * 
	 * Exemple de recherche par id avec ResponseEntity "à la main"
	 */
	@GetMapping("{id}/") //localhost:8080/rest/person/{id}/
    public ResponseEntity<?> findById2(@PathVariable Integer id) {
        Person person;
        try {
			person = personService.findById(id);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body("Pas d'entité trouvée avec cette id");
		}
		return ResponseEntity.ok(person);
	}
	
	@PostMapping
	public Person createPerson(@RequestBody @Valid Person personToCreate) {
        return personService.create(personToCreate);
    }
	
	@PutMapping("{id}")
    public Person updatePerson(@PathVariable Integer id, @RequestBody @Valid Person personToUpdate) {
        return personService.update(personToUpdate);
    }
	
	@GetMapping
    public List<PersonDto> findAll() {
        return personService.findAll();
    }
    
   @DeleteMapping("{id}")
   public void deletePerson(@PathVariable Integer id) {
	   personService.deleteById(id);
   }
   
   @GetMapping("search")
   public List<Person> listTest(
		   @RequestParam(value = "firstname", required = false) String firstname,
		   @RequestParam(value = "lastname", required = false) String lastname,
		   @RequestParam(value = "age", required = false) Integer age){
	  return personService.search(firstname, lastname, age);
   }
   
   @GetMapping("pageable")
   public Page<Person> testPageable(
		   			// page ou on se trouve
		   @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber, 
		   			// nombre de résultat
		   @RequestParam(value = "size", defaultValue = "5") int size){
	  return personService.findAllPageable(PageRequest.of(pageNumber, size));
   }
   
   // methode save pour tester aop
   @GetMapping("/save")
	public Person save(@Valid @RequestBody Person person) {
		return personService.save(null);
	}
   
}
