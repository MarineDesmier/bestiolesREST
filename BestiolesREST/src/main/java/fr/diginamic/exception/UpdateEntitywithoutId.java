package fr.diginamic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UpdateEntitywithoutId extends RuntimeException{
	
	public UpdateEntitywithoutId() {
		super("L'entité à modifier doit avoir un ID");
	}
	
	public UpdateEntitywithoutId(String message) {
		super(message);
	}
}
