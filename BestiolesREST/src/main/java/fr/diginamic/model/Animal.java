package fr.diginamic.model;

import fr.diginamic.enums.Sex;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    @NotEmpty
    private String name;

    @Column(length = 50)
    private String color;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne
    @NotBlank
    private Species species;

    @JsonIgnore
    @ManyToMany(mappedBy = "animals")
    Set<Person> persons;

    // Getters / setters

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
