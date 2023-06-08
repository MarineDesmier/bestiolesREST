package fr.diginamic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

	@ExceptionHandler({ EntityNotFoundException.class, jakarta.persistence.EntityNotFoundException.class,
			BadRequestException.class, UpdateEntitywithoutId.class, CreateEntityWithId.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDto handleExceptionNotFound(Exception exception, WebRequest request) {
		exception.printStackTrace();
		return new ErrorDto(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), exception.getMessage(),
				request.getDescription(false));
	}

//	@ExceptionHandler({ RuntimeException.class })
//	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//	public ErrorDto handleException500(Exception exception, WebRequest request) {
//		exception.printStackTrace();
//		return new ErrorDto(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), exception.getMessage(),
//				request.getDescription(false));
//	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDto handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception, 
			WebRequest request) {
		BindingResult bindingResult = exception.getBindingResult();
		List<FieldError> champErrors = bindingResult.getFieldErrors(); 
		// construction message erreur
		List<String> errorMessages = new ArrayList<>();
		for(FieldError fieldError : champErrors) {
			String errorMessage = fieldError.getDefaultMessage();
			errorMessages.add(errorMessage);
		}
		return new ErrorDto(HttpStatus.BAD_REQUEST.value(), 
				LocalDateTime.now(), 
				errorMessages.toString(),
				request.getDescription(false));
	}
}
