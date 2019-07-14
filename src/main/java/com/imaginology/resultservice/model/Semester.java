package com.imaginology.resultservice.model;

public enum Semester {
	FIRST(1, "First"), 
	SECOND(2, "Second"), 
	THIRD(3, "Third"), 
	FOURTH(4, "Fourth"), 
	FIFTH(5, "Fifth"), 
	SIXTH(6, "Sixth"), 
	SEVENTH(7, "Seventh"), 
	EIGHTH(8, "Eighth");
	
	private final Integer value;
	private final String description;

	Semester(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

	/**
	 * Return the String value of this status.
	 */
	public Integer value() {
		return this.value;
	}

	/**
	 * Return the description of this status.
	 */
	public String getReasonPhrase() {
		return this.description;
	}

	/**
	 * Return the enum constant of this type with the specified string value.
	 *
	 * @param statusCode the string value of the enum to be returned
	 * @return the enum constant with the specified string value
	 * @throws IllegalArgumentException if this enum has no constant for the specified
	 * string value
	 */
	public static Semester getSemester(Integer statusCode) {
		for (Semester semester : values()) {
			if (semester.value.equals(statusCode)) {
				return semester;
			}
		}
		throw new IllegalArgumentException(
				"No matching constant for [" + statusCode + "]");
	}

	/**
	 * Return the string value of this status code.
	 */
	public Integer getValue() {
		return this.value;
	}
}



