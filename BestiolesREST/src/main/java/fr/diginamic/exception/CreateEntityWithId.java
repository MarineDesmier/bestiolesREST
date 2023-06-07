package fr.diginamic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreateEntityWithId extends RuntimeException{
	
	public CreateEntityWithId() {
		super("L'entité à créer ne doit pas avoir d'ID");
	}
	
	public CreateEntityWithId(String message) {
		super(message);
	}
}
