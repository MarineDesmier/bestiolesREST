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

import fr.diginamic.model.Species;
import fr.diginamic.service.SpeciesService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/species")
public class SpeciesController {
	
	@Autowired
	private SpeciesService speciesService;
	
	@GetMapping("{id}") //localhost:8080/rest/species/{id}
    public Species findById(@PathVariable Integer id) {
        return speciesService.findById(id);
	}
	
	@PostMapping
	public Species createSpecies(@RequestBody @Valid Species speciesToCreate) {
        return speciesService.create(speciesToCreate);
    }
	
	@PutMapping("{id}")
    public Species updateSpecies(@PathVariable Integer id, @RequestBody @Valid Species speciesToUpdate) {
        return speciesService.update(speciesToUpdate);
    }
    
	@GetMapping
    public List<Species> findAll() {
        return speciesService.findAll();
    }
    
   @DeleteMapping("{id}")
   public void deletePerson(@PathVariable Integer id) {
	   speciesService.deleteById(id);
   }
}
