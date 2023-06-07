package fr.diginamic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.model.Animal;
import fr.diginamic.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AnimalService {
	
	@Autowired
	AnimalRepository animalRepository;
	
	public Animal findById(Integer id) {
		return animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public List<Animal> findAll() {
		return animalRepository.findAll();
	}
	
	public Animal update(@Valid Animal updateAnimal) {
		return animalRepository.save(updateAnimal);
	}
	
	public Animal create(@Valid Animal updateAnimal) {
		return animalRepository.save(updateAnimal);
	}
	
	public void deleteById(Integer id) {
		animalRepository.deleteById(id);
	}
}
