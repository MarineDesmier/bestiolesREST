package fr.diginamic.dto;

import java.time.LocalDateTime;

/**
 * Class qui sera envoyé lors d'une exception
 * @author Marine
 *
 */
public class ErrorDto {
	private final int statusCode;
	
	private final LocalDateTime localDateTime;
	
	private final String message;
	
	private final String description;
	
	/**
	 * Contructeur
	 * @param statusCode
	 * @param localDateTime
	 * @param message
	 * @param description
	 */
	public ErrorDto(int statusCode,LocalDateTime localDateTime,String message,String description) {
		this.statusCode = statusCode;
		this.localDateTime = localDateTime;
		this.message = message;
		this.description = description;
	}

	// GETTER
	public int getStatusCode() {
		return statusCode;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}
	
}
