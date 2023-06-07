package fr.diginamic.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import fr.diginamic.dto.ErrorDto;
import fr.diginamic.exception.BadRequestException;
import fr.diginamic.exception.CreateEntityWithId;
import fr.diginamic.exception.EntityNotFoundException;
import fr.diginamic.exception.UpdateEntitywithoutId;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler({
		EntityNotFoundException.class,
		jakarta.persistence.EntityNotFoundException.class,
		BadRequestException.class,
		UpdateEntitywithoutId.class,
		CreateEntityWithId.class
	})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDto handleExceptionNotFound(Exception exception, WebRequest request) {
		exception.printStackTrace();
		return new ErrorDto(
				HttpStatus.BAD_REQUEST.value(),
				LocalDateTime.now(),
				exception.getMessage(),
				request.getDescription(false)); 
	}
	
	@ExceptionHandler({RuntimeException.class})
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDto handleException500(Exception exception, WebRequest request) {
		exception.printStackTrace();
		return new ErrorDto(
				HttpStatus.BAD_REQUEST.value(),
				LocalDateTime.now(),
				exception.getMessage(),
				request.getDescription(false)); 
	}
}
