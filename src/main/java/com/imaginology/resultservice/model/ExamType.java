package com.imaginology.resultservice.model;

public enum ExamType {
	UNIT_TEST(1, "Unit Test"),
	
	MID_TERM(2, "Mid Term"), 
	PRE_BOARD(3, "Pre Board"), 
	PRESENTATION(4, "Presentation"), 
	PRACTICAL(5, "Practical"),
	FIRST_TERM(6,"first Term");
	
	
	private final Integer value;
	private final String description;

	ExamType(Integer value, String description) {
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
	public static ExamType getExamType(Integer statusCode) {
		for (ExamType examType : values()) {
			if (examType.value.equals(statusCode)) {
				return examType;
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
