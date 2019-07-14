package com.imaginology.resultservice.exception;

/**
 * Uses if object is not found.
 * 
 * @author Yubaraj Kalathoki
 * @version 1.0.0
 * @since 1.0.0, Mar 13, 2017
 */
public class NotFoundException extends ServiceException {

	private static final long serialVersionUID = -1997692479148550643L;

	public NotFoundException(String message) {
		super(message);
	}

}