package fr.diginamic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.model.Species;
import fr.diginamic.repository.SpeciesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class SpeciesService {
	@Autowired
	SpeciesRepository speciesRepository;
	
	public Species findById(Integer id) {
		return speciesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public List<Species> findAll() {
		return speciesRepository.findAll();
	}
	
	public Species update(@Valid Species updateSpecies) {
		return speciesRepository.save(updateSpecies);
	}
	
	public Species create(@Valid Species updateSpecies) {
		return speciesRepository.save(updateSpecies);
	}
	
	public void deleteById(Integer id) {
		speciesRepository.deleteById(id);
	}
	
}
