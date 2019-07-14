package com.imaginology.resultservice.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties
public class SubjectResponse {
	
	private Long id;
	private String alias;
	private String name;
	private String subjectName;
	private Integer fullMarks;
	private Integer passMarks;
}
