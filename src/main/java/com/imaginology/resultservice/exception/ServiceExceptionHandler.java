package com.imaginology.resultservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ServiceExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Error handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		BindingResult bindingResult = exception.getBindingResult();
		FieldError fieldError = bindingResult.getFieldError();
		return new Error(HttpStatus.BAD_REQUEST.value(), fieldError.getDefaultMessage(), exception.getMessage());
	}

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Error handleValidationException(ValidationException exception) {
		return new Error(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), exception.toString());
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public Error handleNotFoundException(NotFoundException exception) {
		return new Error(HttpStatus.NO_CONTENT.value(), exception.getMessage(), exception.toString());
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public Error handleUnauthorizedException(UnauthorizedException exception) {
		return new Error(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), exception.toString());
	}
}
