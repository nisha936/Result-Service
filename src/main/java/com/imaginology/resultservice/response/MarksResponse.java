package com.imaginology.resultservice.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarksResponse implements Serializable {

	private double obtainedMarks;
	private String remarks;
}
