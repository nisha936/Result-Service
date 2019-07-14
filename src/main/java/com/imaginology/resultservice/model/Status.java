package com.imaginology.resultservice.model;

/**
 * Enumuration that has defined status.
 * 
 * @author Yubaraj
 * @version 1.0.0
 * @since 1.0.0, Mar 3, 2017
 */
public enum Status {
	/**
	 * {@code ACTIVE Active status}
	 */
	ACTIVE("ACTIVE", "Active status"),
	/**
	 * {@code DELETED Deleted status}
	 */
	DELETED("DELETED", "Deleted status"),
	/**
	 * {@code BLOCKED Blocked status}
	 */
	BLOCKED("BLOCKED", "Blocked status"),
	/**
	 * {@code SUSPENDED suspended status}
	 */
	SUSPENDED("SUSPENDED", "Suspended status");

	private final String value;
	private final String description;

	Status(String value, String description) {
		this.value = value;
		this.description = description;
	}

	/**
	 * Return the String value of this status.
	 */
	public String value() {
		return this.value;
	}

	/**
	 * Return the description of this status.
	 */
	public String getReasonPhrase() {
		return this.description;
	}

	/**
	 * Return a string representation of this status value.
	 */
	@Override
	public String toString() {
		return this.value;
	}
}
