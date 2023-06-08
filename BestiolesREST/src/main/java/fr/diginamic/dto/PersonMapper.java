package fr.diginamic.dto;

import java.util.Set;

import org.springframework.stereotype.Component;

import fr.diginamic.model.Animal;
import fr.diginamic.model.Person;

@Component
public class PersonMapper {
	// tranforme une personne en PersonDto
	public PersonDto toPersonDto(Person person) {
		PersonDto dto = new PersonDto(0, null, null);
		dto.setId(person.getId());
		dto.setNomAge(
				person.getFirstname() + " " + 
				person.getLastname().toUpperCase() + " " + 
				person.getAge() + " ans."
		);
		// recherche des animaux
		Set<Animal> animals = person.getAnimals();
		if(animals != null && !animals.isEmpty()) {
			String[] listAnimaux = new String[animals.size()];
			int i = 0;
			for(Animal animal : animals) {
				String animalInfo = animal.getName()+" ("+animal.getSpecies()+")";
				listAnimaux[i] = animalInfo;
				i++;
			}
			dto.setAnimaux(listAnimaux);
		}
		return dto;
	}
}
