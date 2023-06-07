package fr.diginamic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class EntityNotFoundException extends RuntimeException{
	
	public EntityNotFoundException() {
		super("Entité non trouvée !!!");
	}
}
