
package com.imaginology.resultservice.exception;

/**
 * Main exception class for service.
 * 
 * @author Yubaraj Kalathoki
 * @version 1.0.0
 * @since 1.0.0, Mar 13, 2017
 */
public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2802421533449965433L;

	private String message;

	public ServiceException(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}
