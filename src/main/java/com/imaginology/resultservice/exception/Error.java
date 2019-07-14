package com.imaginology.resultservice.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(Include.NON_NULL)
public class Error {

	private int status;
	private String message;
	private String reason;

	public Error() {
	}

	public Error(int status) {
		this.status = status;
	}

	public Error(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public Error(int status, String message, String reason) {
		this.status = status;
		this.message = message;
		this.reason = reason;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
