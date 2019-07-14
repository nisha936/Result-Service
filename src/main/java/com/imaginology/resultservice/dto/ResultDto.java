package com.imaginology.resultservice.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import ch.qos.logback.core.status.Status;

public class ResultDto implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	
	
	
	@NotNull
	private Long courseId;
	@NotNull
	private Long studentId;
	@NotNull
	private Long subjectId;
	@Column(nullable = false)
	private Integer semester;
	private Integer examType;
	private Integer fullMarks;
	private Integer passMarks;
	private Double obtainedMarks;
	private String remarks;
}

	
