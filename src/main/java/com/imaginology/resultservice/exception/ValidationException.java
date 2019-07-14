package com.imaginology.resultservice.exception;

public class ValidationException extends RuntimeException {
	private String message;

	public ValidationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
