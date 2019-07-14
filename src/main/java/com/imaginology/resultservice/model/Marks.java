package com.imaginology.resultservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Marks implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate")
	protected Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedDate")
	protected Date modifiedDate;

	protected Long createdBy;

	protected Long modifiedBy;

	@Enumerated(EnumType.STRING)
	protected Status status;

	protected Long deletedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deletedDate")
	protected Date deletedDate;
	@NotNull
	private Long customerId;
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
	private boolean approved;
	private Long approvedBy;
	private Date approvedDate;

	public Semester getSemester() {
		return Semester.getSemester(semester);
	}

	public void setSemester(Semester semester) {
		this.semester = semester.getValue();
	}

	public ExamType getExamType() {
		return ExamType.getExamType(examType);
	}

	public void setExamType(ExamType examType) {
		this.examType = examType.getValue();
	}

	public Marks() {
		super();
	}
}
