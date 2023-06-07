package fr.diginamic.dto;

import org.springframework.stereotype.Component;

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
		dto.equals(person.getAnimals());
		return dto;
	}
}
