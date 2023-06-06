package fr.diginamic.repository;

import fr.diginamic.model.Person;

import java.util.List;

public interface PersonRepositoryCustom {

    int deletePersonsWithoutAnimal();
    
    public void addPerson(Integer nbPersonnes);

    void insertRandomPersons(int numberToCreate);

    List<Person> testCriterias(String firstname, String lastname, Integer age);
}
